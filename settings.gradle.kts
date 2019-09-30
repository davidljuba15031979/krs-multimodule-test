/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 *
 * Detailed information about configuring a multi-project build in Gradle can be found
 * in the user manual at https://docs.gradle.org/5.5/userguide/multi_project_builds.html
 */

rootProject.name = "krs-core"

include("krs-domain:krs-course:krs-application")
include("krs-spring-app")
include("krs-security")
include("krs-domain:krs-course:krs-adapters:krs-persistence")
include("krs-domain:krs-course:krs-adapters:krs-web")
include("krs-docker")
