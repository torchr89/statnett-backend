package no.statnett.backend.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class ItemDTO(
        val title: String,
        val description: String,
)

@Serializable
data class MetDTO(
        val description: String,
        val items: List<ItemDTO>,
        val nrItems: Int,
)
