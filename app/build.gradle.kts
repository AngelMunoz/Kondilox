/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.2.1/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.8.20"
    kotlin("kapt") version "1.9.0"

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    // Use the JUnit 5 integration.
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:31.1-jre")
    // added by me

    // Coroutines because why not?
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

    // CLI Framework Bits
    implementation("info.picocli:picocli:4.7.4")
    annotationProcessor("info.picocli:picocli-codegen:4.7.4")
    kapt("info.picocli:picocli-codegen:4.7.4")

    // logging stuff
    implementation("ch.qos.logback:logback-classic:1.4.11")
    implementation("io.github.oshai:kotlin-logging-jvm:5.1.0")

}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

kapt {
    arguments {
        arg("project", "${project.group}/${project.name}")
    }
}

application {
    // Define the main class for the application.
    mainClass.set("com.github.angelmunoz.AppKt")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
