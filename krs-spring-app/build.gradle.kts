import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    // Apply the application plugin to add support for building a CLI application.
    application
}

// how to exclude dependency: https://stackoverflow.com/questions/56375085/how-to-exclude-library-from-all-dependencies-in-kotlin-dsl-build-gradle
// removing spring-boot-starter-logging and then log4j-to-slf4j as of: "Caused by: org.apache.logging.log4j.LoggingException: log4j-slf4j-impl cannot be present with log4j-to-slf4j"
// analysed with command: gradle krs-adapters:krs-persistence:dependencies
configurations.forEach { it.exclude("org.springframework.boot", "spring-boot-starter-logging") }

repositories {
    mavenCentral()
}

dependencies {
    implementation( project(":krs-domain"))

    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")

    // slf4j(from kotlintest) -> log4j2 (implementation) -> yaml (configuration)
    implementation("org.apache.logging.log4j:log4j-api:2.12.0")
    implementation("org.apache.logging.log4j:log4j-core:2.12.0")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.12.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.9.9")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.9.1")
}

application {
    // Define the main class for the application
    mainClassName = "com.nortal.KrsSpringApplicationKt"
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
