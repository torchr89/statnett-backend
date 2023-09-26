package no.statnett.backend

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.application.Application
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    val server = embeddedServer(
        Netty,
        applicationEngineEnvironment {
            connector {
                port = 8080
            }

            module {
                serverModule()
            }
        }
    )
    server.start(wait = true)
}

fun Application.serverModule() {
    install(ContentNegotiation) {
        jackson {
            registerKotlinModule()
            registerModule(JavaTimeModule())
            configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        }
    }
}
