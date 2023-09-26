package no.statnett.backend.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.headers
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import no.statnett.backend.api.domain.MetData
import no.statnett.backend.api.domain.toDTO
import no.statnett.backend.util.xmlDeserializer

val urlMetResource = "https://api.met.no/weatherapi/metalerts/1.1?show=all"
val xmlParser = xmlDeserializer()

fun Routing.registerMetApi(httpClient: HttpClient) {
    route("/api/met") {
        get {
            val metDataAsString: String = httpClient
                .get(urlMetResource) {
                    headers {
                        header(HttpHeaders.Accept, "application/rss+xml")
                    }
                }
                .body()

            val metData = xmlParser.readValue(metDataAsString, MetData::class.java,)
            call.respond(metData.toDTO())
        }
    }
}
