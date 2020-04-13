package io.material.mdts.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import io.material.mdts.R
import io.material.mdts.util.openDrawer
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val adapter = HomeAdapter()
    // TODO: Home list items
    private val items = listOf(
        "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
        "Item 6", "Item 7", "Item 8", "Item 19", "Item 10",
        "Item 11", "Item 12", "Item 13", "Item 14", "Item 15",
        "Item 16", "Item 17", "Item 18", "Item 19", "Item 20"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.setNavigationOnClickListener { openDrawer() }
        recyclerView.adapter = adapter
        adapter.submitList(items)
    }
}
