package no.statnett.backend

import io.ktor.client.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.application.Application
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import no.statnett.backend.api.registerMetApi
import no.statnett.backend.api.registerEarthquakeApi
import no.statnett.backend.client.httpClient

fun main() {
    val httpClient = httpClient()
    val server = embeddedServer(
        Netty,
        applicationEngineEnvironment {
            connector {
                port = 8080
            }

            module {
                serverModule(httpClient)
            }
        }
    )
    server.start(wait = true)
}

fun Application.serverModule(httpClient: HttpClient) {
    install(ContentNegotiation) {
        json()
    }

    install(Routing) {
        registerEarthquakeApi(httpClient)
        registerMetApi(httpClient)
    }

}
