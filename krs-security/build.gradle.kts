import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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
        mavenBom("org.springframework.boot:spring-boot-dependencies:2.1.8.RELEASE") {
            bomProperty("kotlin.version", "1.3.50") // https://youtrack.jetbrains.com/issue/KT-27994#focus=streamItem-27-3148043.0-0
        }
    }
}

// how to exclude dependency: https://stackoverflow.com/questions/56375085/how-to-exclude-library-from-all-dependencies-in-kotlin-dsl-build-gradle
// removing spring-boot-starter-logging and then log4j-to-slf4j as of: "Caused by: org.apache.logging.log4j.LoggingException: log4j-slf4j-impl cannot be present with log4j-to-slf4j"
// analysed with command: gradle krs-adapters:krs-persistence:dependencies
configurations.forEach { it.exclude("org.springframework.boot", "spring-boot-starter-logging") }


version = "2.1.8.RELEASE"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}





