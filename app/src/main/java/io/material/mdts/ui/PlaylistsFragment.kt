package io.material.mdts.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import io.material.mdts.R
import io.material.mdts.model.Album
import kotlinx.android.synthetic.main.fragment_playlists.*

class PlaylistsFragment : Fragment(R.layout.fragment_playlists) {

    private val adapter = AlbumAdapter { album ->
        // TODO: Show playlist screen
    }
    private val items = listOf(
        Album(title = "Playlist title", metaInfo = "Meta info"),
        Album(title = "Playlist title", metaInfo = "Meta info"),
        Album(title = "Playlist title", metaInfo = "Meta info"),
        Album(title = "Playlist title", metaInfo = "Meta info"),
        Album(title = "Playlist title", metaInfo = "Meta info"),
        Album(title = "Playlist title", metaInfo = "Meta info"),
        Album(title = "Playlist title", metaInfo = "Meta info"),
        Album(title = "Playlist title", metaInfo = "Meta info")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        adapter.submitList(items)
        val space = resources.getDimensionPixelSize(R.dimen.spacing_xs)
        val spaceItemDecoration = SpaceItemDecoration(
            left = space, top = space
        )
        recyclerView.addItemDecoration(spaceItemDecoration)
    }
}
