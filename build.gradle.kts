plugins {
    java
    alias(libs.plugins.loom)
    alias(libs.plugins.minotaur)
}

val id: String by project

loom {
    splitEnvironmentSourceSets()
}

fabricApi {
    configureDataGeneration {
        createSourceSet = true
        strictValidation = true
        modId = id
        client = true
    }
}

java {
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
    maven("https://maven.neoforged.net/releases") { name = "Neoforged" }
    maven("https://files.minecraftforge.net/maven/") { name = "Forge" }
    maven("https://maven.quiltmc.org/repository/release") { name = "Quilt" }
    maven("https://api.modrinth.com/maven") { name = "Modrinth" }
    maven("https://maven.terraformersmc.com") { name = "TerraformersMC" }
    maven("https://maven.ladysnake.org/releases") { name = "Ladysnake Libs" }
    maven("https://maven.theillusivec4.top/") { name = "TheIllusiveC4" }
    maven("https://maven.bawnorton.com/releases") { name = "Bawnorton" }
}

dependencies {
    minecraft(libs.minecraft)
    mappings(variantOf(libs.yarn) { classifier("v2") })
    modImplementation(libs.bundles.fabric)

    annotationProcessor(libs.mixin.squared)

    include(libs.bundles.fabric.bundle)
    modImplementation(libs.bundles.fabric.bundle)

    modRuntimeOnly(libs.bundles.fabric.runtime)
}

tasks {
    processResources {
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
        from("LICENSE*") {
            rename { "${project.name}-${it}" }
        }
    }

    "sourcesJar" {
        dependsOn("runDatagen")
    }
}
