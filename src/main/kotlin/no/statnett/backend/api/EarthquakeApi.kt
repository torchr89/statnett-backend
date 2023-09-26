package no.statnett.backend.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val urlEarthquakeResource = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/1.0_hour.geojson"
fun Routing.registerEarthquakeApi(httpClient: HttpClient) {
    route("/api/earthquake") {
        get {
            val earthquakeData: String = httpClient
                .get(urlEarthquakeResource)
                .body()

            call.respondText(earthquakeData)
        }
    }
}
