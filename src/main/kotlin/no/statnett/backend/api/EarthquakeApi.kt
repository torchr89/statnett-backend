package no.statnett.backend.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import no.statnett.backend.api.domain.EarthquakeData
import no.statnett.backend.api.domain.toDTO

val urlEarthquakeResource = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/1.0_hour.geojson"
fun Routing.registerEarthquakeApi(httpClient: HttpClient) {
    route("/api/earthquake") {
        get {
            val earthquakeData: EarthquakeData = httpClient
                .get(urlEarthquakeResource) {
                    headers {
                        header(HttpHeaders.Accept, "application/json")
                    }
                }
                .body()

            call.respond(earthquakeData.toDTO())
        }
    }
}
