package io.material.mdts.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.doOnPreDraw
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import io.material.mdts.R
import io.material.mdts.model.sections
import io.material.mdts.util.openDrawer
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val adapter = SectionAdapter { itemView, album ->
        val directions = HomeFragmentDirections.homeToPlaylist(id = album.id)
        val extras = FragmentNavigatorExtras(itemView to itemView.transitionName)
        findNavController().navigate(directions, extras)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Postpone enter transitions to allow shared element transitions to run
        // See: https://github.com/googlesamples/android-architecture-components/issues/495
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
        toolbar.setNavigationOnClickListener { openDrawer() }
        recyclerView.adapter = adapter
        adapter.submitList(sections)
        val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
        ViewCompat.setOnApplyWindowInsetsListener(appBar) { v, insets ->
            v.updatePadding(top = insets.systemWindowInsets.top)
            insets
        }
        ViewCompat.setOnApplyWindowInsetsListener(recyclerView) { v, insets ->
            v.updatePadding(bottom = insets.systemWindowInsets.bottom)
            insets
        }
    }
}
