group = "no.statnett.backend"
version = "1.0"

val ktorVersion = "2.3.4"


plugins {
    kotlin("jvm") version "1.9.10"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.10"
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
    implementation("io.ktor:ktor-client-jackson:$ktorVersion")
    implementation("io.ktor:ktor-serialization-jackson:$ktorVersion")

}

repositories {
    mavenCentral()
}
