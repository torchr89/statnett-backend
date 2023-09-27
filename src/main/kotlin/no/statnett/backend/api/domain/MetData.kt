package no.statnett.backend.api.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import no.statnett.backend.api.dto.ItemDTO
import no.statnett.backend.api.dto.MetDTO

@Serializable
data class Item (
        val title: String,
        val description: String
)
@Serializable
data class Channel (
        val description: String,
        val item: List<Item>
)

@Serializable
@SerialName("rss")
data class MetData (
        val channel: Channel
)

fun MetData.toDTO() =
        MetDTO(
                description = this.channel.description,
                items = this.channel.item.map {
                    ItemDTO(
                            title = it.title,
                            description = it.description,
                    )
                },
                nrItems = this.channel.item.size
        )
