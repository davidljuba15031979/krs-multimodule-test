
plugins {
    kotlin("jvm")
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    implementation( project(":krs-domain:krs-course:krs-adapters:krs-web"))
    implementation( project(":krs-domain:krs-course:krs-adapters:krs-persistence"))
}