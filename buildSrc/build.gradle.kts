plugins {
    `java-gradle-plugin`
}

gradlePlugin {
    plugins {
        create("buildPlugin") {
            id = "gay.ampflower.BuildPlugin"
            implementationClass = "gay.ampflower.BuildPlugin"
        }
    }
}
