package io.material.mdts.model

import java.util.UUID

data class Section(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val albums: List<Album>
)
