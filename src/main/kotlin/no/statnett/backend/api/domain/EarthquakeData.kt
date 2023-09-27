package no.statnett.backend.api.domain

import kotlinx.serialization.Serializable
import no.statnett.backend.api.dto.EarthquakeDTO
import no.statnett.backend.api.dto.FeatureDTO
import java.time.Instant
import java.time.ZoneId

@Serializable
data class Property(
    val title: String,
    val type: String,
    val mag: Float?,
    val sig: Int?,
    val gap: Int?,
    val place: String,
    val time: Long,
) {
    override fun toString() =
            "${time.toLocalDateTime()}: " +
                    " $title | $type |" +
                    " ${mag ?: "<N/A>"} | ${sig ?: "<N/A>"} | ${gap ?: "<N/A>"}" +
                    " | $place"
}

@Serializable
data class Feature(
    val type: String,
    val properties: Property
)

@Serializable
data class Metadata(
        val title: String
)

@Serializable
data class EarthquakeData (
        val features: List<Feature>,
        val metadata: Metadata,
)

fun Long.toLocalDateTime() = Instant
        .ofEpochMilli(this)
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime()

fun EarthquakeData.toDTO() = EarthquakeDTO(
        features = this.features.map {
            FeatureDTO(
                    it.type,
                    "${it.properties}"
            )
        },
        title = this.metadata.title,
        nrFeatures = this.features.size,
)
