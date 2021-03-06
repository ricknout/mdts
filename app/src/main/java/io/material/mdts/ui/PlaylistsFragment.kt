package io.material.mdts.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import io.material.mdts.R
import io.material.mdts.model.playlists
import kotlinx.android.synthetic.main.fragment_playlists.*

class PlaylistsFragment : Fragment(R.layout.fragment_playlists) {

    private val adapter = AlbumAdapter { itemView, album ->
        val directions = MyLibraryFragmentDirections.myLibraryToPlaylist(id = album.id)
        val extras = FragmentNavigatorExtras(itemView to itemView.transitionName)
        findNavController().navigate(directions, extras)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        adapter.submitList(playlists)
        val space = resources.getDimensionPixelSize(R.dimen.spacing_xs)
        val spaceItemDecoration = SpaceItemDecoration(
            left = space, top = space
        )
        recyclerView.addItemDecoration(spaceItemDecoration)
    }
}
