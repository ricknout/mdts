package io.material.mdts.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.google.android.material.transition.MaterialContainerTransform
import io.material.mdts.R
import io.material.mdts.util.TRANSITION_DURATION
import io.material.mdts.util.TRANSITION_NAME_PLAYLIST
import kotlinx.android.synthetic.main.fragment_playlist.*
import kotlin.math.abs

class PlaylistFragment : Fragment(R.layout.fragment_playlist) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transformation: MaterialContainerTransform = MaterialContainerTransform().apply {
            fadeMode = MaterialContainerTransform.FADE_MODE_CROSS
            duration = TRANSITION_DURATION
        }
        sharedElementEnterTransition = transformation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.transitionName = TRANSITION_NAME_PLAYLIST
        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        appBar.addOnOffsetChangedListener(OnOffsetChangedListener { appBarLayout, verticalOffset ->
            image.alpha = 1.0f - abs(verticalOffset / appBarLayout.totalScrollRange.toFloat())
        })
    }
}
