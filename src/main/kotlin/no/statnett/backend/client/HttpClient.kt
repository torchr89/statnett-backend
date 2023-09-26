package no.statnett.backend.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.*
import io.ktor.serialization.kotlinx.xml.*

fun httpClient(): HttpClient {
    return HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
            xml()
        }
    }
}