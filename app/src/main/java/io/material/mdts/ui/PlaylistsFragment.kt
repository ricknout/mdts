package io.material.mdts.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import io.material.mdts.R
import kotlinx.android.synthetic.main.fragment_playlists.*

// TODO: Playlists screen
class PlaylistsFragment : Fragment(R.layout.fragment_playlists) {

    private val adapter = PlaylistsAdapter()
    // TODO: Playlists list items
    private val items = listOf(
        "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
        "Item 6", "Item 7", "Item 8", "Item 19", "Item 10",
        "Item 11", "Item 12", "Item 13", "Item 14", "Item 15",
        "Item 16", "Item 17", "Item 18", "Item 19", "Item 20",
        "Item 21", "Item 22", "Item 23", "Item 24", "Item 25",
        "Item 26", "Item 27", "Item 28", "Item 29", "Item 30",
        "Item 31", "Item 32", "Item 33", "Item 34", "Item 35",
        "Item 36", "Item 37", "Item 38", "Item 39", "Item 40"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        adapter.submitList(items)
    }
}
