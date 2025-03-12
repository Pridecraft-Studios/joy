val xplat = project(":xplat")
val xplatClient = xplat.sourceSets.client.get()
val xplatMain = xplat.sourceSets.main.get()

val modrinthId: String by project

dependencies {
    modImplementation(libs.bundles.fabric)
    compileOnly(project(":xplat", configuration = "namedElements"))
    clientCompileOnly(xplatClient.output)

    modCompileOnly(variantOf(rootProject.libs.emi.fabric) { classifier("api") })

    include(libs.bundles.fabric.bundle)
    modImplementation(libs.bundles.fabric.bundle)
    modRuntimeOnly(libs.bundles.fabric.runtime)

    modClientRuntimeOnly(libs.bundles.fabric.client.runtime)
}

tasks {
    compileClientJava {
        source(xplatClient.allSource)
    }
    compileJava {
        source(xplatMain.allSource)
    }
    processClientResources {
        from(xplatClient.resources)
    }
    processResources {
        from(xplatMain.resources)
    }
    publish {
        dependsOn(modrinth)
    }
}

modrinth {
    token.set(System.getenv("MODRINTH_TOKEN"))
    projectId.set(modrinthId)
    //versionType.set(meta.releaseType)
    //versionName.set("${meta.projectVersion} - Fabric ${libs.versions.minecraft.version.get()}")
    versionNumber.set("${project.version}-fabric")
    //changelog.set(meta.changelog)
    uploadFile.set(tasks.remapJar)
    dependencies {
    }
    //gameVersions.set(meta.minecraftCompatible)
    loaders.addAll("fabric", "quilt")
}
