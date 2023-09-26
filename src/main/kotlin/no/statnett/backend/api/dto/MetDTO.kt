package no.statnett.backend.api.dto

data class ItemDTO(
        val title: String,
        val description: String,
)

data class MetDTO(
        val description: String,
        val items: List<ItemDTO>,
)
