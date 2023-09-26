package no.statnett.backend.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val urlMetResource = "https://api.met.no/weatherapi/metalerts/1.1?show=all"
fun Routing.registerMetApi(httpClient: HttpClient) {
    route("/api/met") {
        get {
            val metData: String = httpClient
                .get(urlMetResource)
                .body()

            call.respondText(metData)
        }
    }
}
