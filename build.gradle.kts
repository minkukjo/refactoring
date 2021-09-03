import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.30"
    kotlin("plugin.serialization") version "1.5.30"
}

group = "me.harry"
version = "1.0-SNAPSHOT"
val kotlinSerializationVersion = "1.2.2"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${kotlinSerializationVersion}")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}