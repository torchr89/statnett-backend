import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "no.statnett.backend"
version = "1.0"

val ktorVersion = "2.3.4"
val jacksonVersion = "2.13.2"
val jacksonDatabindVersion = "2.13.4.1"
val logbackVersion = "1.2.9"
val logstashEncoderVersion = "7.0.1"


plugins {
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.serialization") version "1.9.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.10"
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

allOpen {
    annotation("no.statnett.backend.annotation.Mockable")
}

dependencies {
    // Ktor server
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-server-cors:$ktorVersion")
    implementation("io.ktor:ktor-client-jackson:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-xml:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")

    // JSON/XML parsing
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonDatabindVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:$jacksonVersion")

    // Logging
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("net.logstash.logback:logstash-logback-encoder:$logstashEncoderVersion")
}

repositories {
    mavenCentral()
}

tasks {
    withType<ShadowJar> {
        manifest.attributes["Main-Class"] = "no.statnett.backend.ApplicationKt"
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "19"
    }
}