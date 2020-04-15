package io.material.mdts.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import io.material.mdts.R
import io.material.mdts.util.TRANSITION_NAME_NOW_PLAYING
import io.material.mdts.util.openDrawer
import kotlinx.android.synthetic.main.fragment_my_library.*
import kotlinx.android.synthetic.main.layout_now_playing.*

class MyLibraryFragment : Fragment(R.layout.fragment_my_library) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.setNavigationOnClickListener { openDrawer() }
        viewPager.adapter = MyLibraryAdapter(this)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = when (position) {
                POSITION_PLAYLISTS -> getString(R.string.playlists)
                POSITION_ALBUMS -> getString(R.string.albums)
                POSITION_ARTISTS -> getString(R.string.artists)
                else -> null
            }
        }.attach()
        card.setOnClickListener { cardView ->
            cardView.transitionName = TRANSITION_NAME_NOW_PLAYING
            val extras = FragmentNavigatorExtras(cardView to TRANSITION_NAME_NOW_PLAYING)
            findNavController().navigate(R.id.myLibraryToNowPlaying, null, null, extras)
        }
    }

    inner class MyLibraryAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun createFragment(position: Int) = when (position) {
            POSITION_PLAYLISTS -> PlaylistsFragment()
            POSITION_ALBUMS -> AlbumsFragment()
            POSITION_ARTISTS -> ArtistsFragment()
            else -> throw IllegalArgumentException("Position $position exceeds HomeAdapter count")
        }

        override fun getItemCount() = 3
    }

    companion object {
        private const val POSITION_PLAYLISTS = 0
        private const val POSITION_ALBUMS = 1
        private const val POSITION_ARTISTS = 2
    }
}
