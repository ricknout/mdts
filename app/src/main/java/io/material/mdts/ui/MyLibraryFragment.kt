package io.material.mdts.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import io.material.mdts.R
import io.material.mdts.openDrawer
import kotlinx.android.synthetic.main.fragment_my_library.*

class MyLibraryFragment : Fragment(R.layout.fragment_my_library) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.setNavigationOnClickListener { openDrawer() }
    }
}
