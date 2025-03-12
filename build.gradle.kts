import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap
import java.io.IOException
import java.nio.file.Files
import javax.imageio.ImageIO

plugins {
    java
    alias(libs.plugins.loom)
    alias(libs.plugins.minotaur)
}

val id: String by project

val excluded = setOf(rootProject, project(":xplat"))

allprojects {
    apply(plugin = "java")
    apply(plugin = rootProject.libs.plugins.loom.get().pluginId)
    apply(plugin = rootProject.libs.plugins.minotaur.get().pluginId)

    val libs = rootProject.libs

    base {
        if (project != rootProject) {
            archivesName.set(rootProject.name + '-' + project.name)
        }
    }

    loom {
        mixin {
            defaultRefmapName = "joy.refmap.json"
        }

        splitEnvironmentSourceSets()
        runs {
            named("client") {
                client()
                configName = "${project.name.replaceFirstChar(Char::uppercase)} Client"
                ideConfigGenerated(project !in excluded)
                runDir(rootProject.relativePath("run"))
            }
            named("server") {
                server()
                configName = "${project.name.replaceFirstChar(Char::uppercase)} Server"
                ideConfigGenerated(project !in excluded)
                runDir(rootProject.relativePath("run"))
            }
        }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
        withSourcesJar()
    }

    repositories {
        mavenCentral()
        maven("https://maven.neoforged.net/releases") { name = "Neoforged" }
        maven("https://files.minecraftforge.net/maven/") { name = "Forge" }
        maven("https://maven.quiltmc.org/repository/release") { name = "Quilt" }
        maven("https://repo.sleeping.town") {
            name = "Sleeping Town"
            content {
                includeGroup("com.unascribed")
            }
        }
        maven("https://api.modrinth.com/maven") { name = "Modrinth" }
        maven("https://maven.terraformersmc.com") { name = "TerraformersMC" }
        maven("https://maven.ladysnake.org/releases") { name = "Ladysnake Libs" }
        maven("https://maven.theillusivec4.top/") { name = "TheIllusiveC4" }
        maven("https://maven.bawnorton.com/releases") { name = "Bawnorton" }
    }

    dependencies {
        minecraft(libs.minecraft)
        mappings(variantOf(libs.yarn) { classifier("v2") })

        modCompileOnly(libs.bundles.common.compile)

        annotationProcessor(libs.mixin.squared)
        modImplementation(libs.bundles.common.bundle)
        include(libs.bundles.common.bundle)
    }

    tasks {
        withType<ProcessResources> {
            if (project !in excluded) {
                project(":xplat").afterEvaluate { dependsOn(tasks.named("runDatagen")) }
            }

            val map = mapOf(
                "id" to id,
                "version" to version,
                "java" to java.targetCompatibility.majorVersion,
                "loader" to libs.versions.fabric.loader.get(),
                "minecraftRequired" to libs.versions.minecraft.required.get(),
            )

            inputs.properties(map)

            filesMatching(listOf("fabric.mod.json", "quilt.mod.json", "META-INF/mods.toml")) {
                expand(map)
            }

            exclude("*/.editorconfig")
        }

        withType<JavaCompile> {
            options.encoding = "UTF-8"
            options.release = 21
        }

        withType<Jar> {
            dependsOn("runDatagen")
            from("LICENSE*") {
                rename { "${project.name}-${it}" }
            }
        }

        register("publish")
    }
}

tasks {
    register("imageCleanup") {
        val prop = System.getProperties()
        val cleanupSource = prop.getProperty("cleanupSource")

        notCompatibleWithConfigurationCache("not ready for caching")

        onlyIf { cleanupSource != null }

        if (cleanupSource != null) {
            inputs.files(cleanupSource, sourceSets.main.get().resources)
        }

        doLast {
            data class ImgData(
                val file: File,
                val image: IntArray,
                val badMips: Boolean,
                val update: MutableSet<File> = HashSet(),
                val hit: MutableSet<File> = HashSet()
            ) {
                override fun toString(): String {
                    return "$file => ${image.size} pixels\n\tupdate => $update\n\thit => $hit"
                }

                fun isMissed(): Boolean = update.isEmpty() && hit.isEmpty()
            }

            val map = Long2ObjectOpenHashMap<ImgData>()

            fun doWork(file: File) {
                if (file.extension != "png") {
                    return
                }

                val img = ImageIO.read(file)

                val w = img.width
                val h = img.height

                val data = img.getRGB(0, 0, w, h, null, 0, w)

                var hash = 0L

                for (i in data.indices) {
                    val c = data[i]
                    if (c and 0xFF000000.toInt() == 0) {
                        data[i] = 0
                    }
                }
                for (d in data) {
                    hash = hash * 31L + d
                }

                val other = map.get(hash)

                // Kotlin kept randomly stating that the variable other is always null,
                // then had the audacity to tell me the suppression was redundant.
                @Suppress("KotlinConstantConditions", "RedundantSuppression")
                if (other == null) {
                    map.put(hash, ImgData(file, data, (w and 15) or (w and 15) != 0))
                    return
                }

                if (!other.image.contentEquals(data)) {
                    logger.warn("{} != {}", file, other.file)
                    return
                }

                val selfSize = Files.size(file.toPath())
                val otherSize = Files.size(other.file.toPath())

                if (selfSize < otherSize) {
                    logger.info("{} < {} => {} < {}; replace", file, other.file, selfSize, otherSize)
                    map.put(hash, ImgData(file, data, other.badMips, update = HashSet(other.update + other.hit + other.file)))
                    return
                }

                if (selfSize > otherSize) {
                    logger.info("{} > {} => {} > {}; update", file, other.file, selfSize, otherSize)
                    other.update += file
                    return
                }

                logger.info("{} = {} => {} = {}; hit", file, other.file, selfSize, otherSize)
                other.hit += file
            }

            for (file in project.fileTree(cleanupSource)) {
                doWork(file)
            }

            for (file in sourceSets.main.get().resources) {
                doWork(file)
            }

            for ((k, v) in map) {
                logger.info("{} => {}", k, v)
            }

            map.values.asSequence()
                .filterNot { it.isMissed() }
                .map { it.file to it.update }
                .forEach {
                    val src = it.first.readBytes()
                    it.second.forEach { dest ->
                        try {
                            dest.writeBytes(src)
                        } catch (e: IOException) {
                            logger.error("Failed to copy {} => {}", src, dest, e)
                        }
                    }
                }

            map.values.asSequence()
                .filter { it.isMissed() }
                .forEach { logger.warn("Missed entry: {}", it.file) }

            map.values.asSequence()
                .filter { it.badMips }
                .forEach { logger.warn("Bad mipmaps: {}", it) }
        }
    }
}
