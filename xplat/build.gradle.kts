val id: String by project

loom {

}

fabricApi {
    configureDataGeneration {
        createSourceSet = true
        // strictValidation = true
        addToResources = true
        modId = id
        client = true
    }
}

// sourceSets.named("datagen").get().resources.source(sourceSets.main.get().resources);

dependencies {
    compileOnly(libs.mixin)

    modRuntimeOnly(libs.fabric.loader)
    "modDatagenImplementation"(libs.fabric.loader)
    "modDatagenImplementation"(libs.fabric.api)
    "modDatagenRuntimeOnly"(libs.bundles.datagen.runtime)

    modCompileOnly(variantOf(rootProject.libs.emi) { classifier("api") })
}

tasks {
    withType<Jar> {
        dependsOn("runDatagen")
    }
}
