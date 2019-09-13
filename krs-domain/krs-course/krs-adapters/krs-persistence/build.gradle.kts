import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin library project to get you started.
 */

//https://www.baeldung.com/junit-5-gradle
val test by tasks.getting(Test::class) {
    useJUnitPlatform { }
}

plugins {
    kotlin("jvm")
    id("io.spring.dependency-management")
}

// https://stackoverflow.com/questions/26353607/gradle-with-no-main-class
dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:2.1.6.RELEASE") {
            bomProperty("kotlin.version", "1.3.50") // https://youtrack.jetbrains.com/issue/KT-27994#focus=streamItem-27-3148043.0-0
        }
    }
}

// how to exclude dependency: https://stackoverflow.com/questions/56375085/how-to-exclude-library-from-all-dependencies-in-kotlin-dsl-build-gradle
// removing spring-boot-starter-logging and then log4j-to-slf4j as of: "Caused by: org.apache.logging.log4j.LoggingException: log4j-slf4j-impl cannot be present with log4j-to-slf4j"
// analysed with command: gradle krs-adapters:krs-persistence:dependencies
configurations.forEach { it.exclude("org.springframework.boot", "spring-boot-starter-logging") }

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}


dependencies {

    implementation(project(":krs-domain:krs-course:krs-application"))
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0-RC")

    // https://stackoverflow.com/questions/53277045/how-does-kotlintest-test-spring-boot-application
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // Use junit 5 (https://www.baeldung.com/junit-5-gradle)
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.1")
    testRuntimeOnly( "org.junit.jupiter:junit-jupiter-engine:5.5.1")
    //ClassNotFound: SelectorResolver...
    testRuntimeOnly("org.junit.platform:junit-platform-engine:1.5.1")
    testRuntimeOnly("org.junit.platform:junit-platform-commons:1.5.1")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    // Use Kotlin test spec Kotlintest (https://github.com/kotlintest/kotlintest)
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.2")

    testImplementation("io.mockk:mockk:1.9.3")
    testImplementation("io.mockk:mockk-common:1.9.3")

    // slf4j(from kotlintest) -> log4j2 (implementation) -> yaml (configuration)
    testImplementation("org.apache.logging.log4j:log4j-api:2.12.0")
    testImplementation("org.apache.logging.log4j:log4j-core:2.12.0")
    testImplementation("org.apache.logging.log4j:log4j-slf4j-impl:2.12.0")
    testImplementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.9.9")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.9.9.1")

}




