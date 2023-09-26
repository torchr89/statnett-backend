group = "no.statnett.backend"
version = "1.0"


plugins {
    kotlin("jvm") version "1.9.10"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.10"
}

allOpen {
    annotation("no.statnett.backend.annotation.Mockable")
}

repositories {
    mavenCentral()
}
