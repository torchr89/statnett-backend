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
    val mag: Float,
    val place: String,
    val time: Long,
) {
    override fun toString() =
            "$title | $type | $mag | $place | ${time.toLocalDateTime()} "
}

@Serializable
data class Feature(
    val type: String,
    val properties: Property
)

@Serializable
data class EarthquakeData (
        val features: List<Feature>
)

fun Long.toLocalDateTime() = Instant
        .ofEpochMilli(this)
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime()

fun EarthquakeData.toDTO() = EarthquakeDTO(
        this.features.map {
            FeatureDTO(
                    it.type,
                    "${it.properties}"
            )
        }
)
