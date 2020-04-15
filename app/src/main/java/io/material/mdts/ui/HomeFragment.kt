package io.material.mdts.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import io.material.mdts.R
import io.material.mdts.model.sections
import io.material.mdts.util.TRANSITION_NAME_PLAYLIST
import io.material.mdts.util.openDrawer
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val adapter = SectionAdapter { itemView, _ ->
        itemView.transitionName = TRANSITION_NAME_PLAYLIST
        val extras = FragmentNavigatorExtras(itemView to TRANSITION_NAME_PLAYLIST)
        findNavController().navigate(R.id.homeToPlaylist, null, null, extras)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.setNavigationOnClickListener { openDrawer() }
        recyclerView.adapter = adapter
        adapter.submitList(sections)
        val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
    }
}
