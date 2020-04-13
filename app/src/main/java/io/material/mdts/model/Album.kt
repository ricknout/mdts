package io.material.mdts.model

import java.util.UUID

data class Album(
    val id: String = UUID.randomUUID().toString(),
    // TODO: Album art drawable res ID / URL
    val title: String,
    val metaInfo: String
)
