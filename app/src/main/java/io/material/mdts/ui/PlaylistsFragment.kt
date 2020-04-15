package io.material.mdts.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import io.material.mdts.R
import io.material.mdts.model.Album
import io.material.mdts.util.TRANSITION_NAME_PLAYLIST
import kotlinx.android.synthetic.main.fragment_playlists.*

class PlaylistsFragment : Fragment(R.layout.fragment_playlists) {

    private val adapter = AlbumAdapter { itemView, _ ->
        itemView.transitionName = TRANSITION_NAME_PLAYLIST
        val extras = FragmentNavigatorExtras(itemView to TRANSITION_NAME_PLAYLIST)
        findNavController().navigate(R.id.myLibraryToPlaylist, null, null, extras)
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
