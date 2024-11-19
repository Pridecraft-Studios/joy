plugins {
    java
    id("fabric-loom") version "1.7-SNAPSHOT"
}

class ModInfo {
    val id = property("mod.id").toString()
    val group = property("mod.group").toString()
    val version = property("mod.version").toString()
}

class Dependencies {
    val minecraft = property("deps.minecraft").toString()
    val loader = property("deps.loader").toString()
    val yarn = property("deps.yarn").toString()

    val fabricApi = property("deps.fabricapi").toString()
    val mavApi = property("deps.mavapi").toString()
    val midnightLib = property("deps.midnightlib").toString()
    val badgesLib = property("deps.badgeslib").toString()
}

val mod = ModInfo()
val deps = Dependencies()

version = mod.version
group = mod.group

base.archivesName = "${mod.id}-${mod.version}"

loom {
    splitEnvironmentSourceSets()
    mods.create(mod.id) {
        sourceSet(sourceSets.getByName("main"))
        sourceSet(sourceSets.getByName("client"))
    }
}

repositories {
    mavenCentral()
    maven("https://maven.terraformersmc.com/")
    maven("https://api.modrinth.com/maven")
    maven("https://maven.bawnorton.com/releases")
}

fabricApi {
    configureDataGeneration()
}

dependencies {
    minecraft("com.mojang:minecraft:${deps.minecraft}")
    mappings("net.fabricmc:yarn:${deps.yarn}:v2")
    modImplementation("net.fabricmc:fabric-loader:${deps.loader}")

    modImplementation("net.fabricmc.fabric-api:fabric-api:${deps.fabricApi}")
    modImplementation("maven.modrinth:mavapi:${deps.mavApi}")
    modImplementation("maven.modrinth:midnightlib:${deps.midnightLib}")

    annotationProcessor("com.github.bawnorton.mixinsquared:mixinsquared-fabric:0.2.0")
    include("com.github.bawnorton.mixinsquared:mixinsquared-fabric:0.2.0")
    implementation("com.github.bawnorton.mixinsquared:mixinsquared-fabric:0.2.0")

    include("maven.modrinth:modmenu-badges-lib:${deps.badgesLib}")
    modImplementation("maven.modrinth:modmenu-badges-lib:${deps.badgesLib}")
}

tasks.processResources {
    inputs.property("id", mod.id)
    inputs.property("version", mod.version)
    inputs.property("loader_version", deps.loader)
    inputs.property("minecraft_version", deps.minecraft)

    val map = mapOf(
        "id" to mod.id,
        "version" to mod.version,
        "loader_version" to deps.loader,
        "minecraft_version" to deps.minecraft
    )

    filesMatching("fabric.mod.json") { expand(map) }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release = 21
}

java {
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<Jar> {
    from("LICENSE") { rename { "${it}_${project.base.archivesName.get()}" } }
}