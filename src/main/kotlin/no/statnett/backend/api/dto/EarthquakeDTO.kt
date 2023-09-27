package no.statnett.backend.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class FeatureDTO(
        val type: String,
        val properties: String,
)

@Serializable
data class EarthquakeDTO (
        val features: List<FeatureDTO>,
        val nrFeatures: Int,
)
