package io.material.mdts.model

import java.util.UUID

data class Playlist(
    val id: String = UUID.randomUUID().toString(),
    // TODO: Playlist album art drawable res ID / URL
    val title: String,
    val metaInfo: String
)
