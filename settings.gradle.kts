dependencyResolutionManagement {
	versionCatalogs {
		create("libs") {
			from(files("libs.versions.toml"))
		}
	}
}

pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/") { name = "Fabric" }
        maven("https://maven.architectury.dev/") { name = "Architectury" }
        maven("https://maven.neoforged.net/releases") { name = "Neoforged" }
        maven("https://files.minecraftforge.net/maven/") { name = "Forge" }
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "joy"
include("xplat")
include("fabric")
