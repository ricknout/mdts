package io.material.mdts.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.google.android.material.transition.MaterialContainerTransform
import io.material.mdts.R
import kotlinx.android.synthetic.main.fragment_now_playing.*
import kotlin.math.abs

class NowPlayingFragment : Fragment(R.layout.fragment_now_playing) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transition = MaterialContainerTransform().apply {
            duration = resources.getInteger(R.integer.duration_transition).toLong()
            interpolator = FastOutSlowInInterpolator()
        }
        sharedElementEnterTransition = transition
        sharedElementReturnTransition = transition
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        appBar.addOnOffsetChangedListener(OnOffsetChangedListener { appBarLayout, verticalOffset ->
            image.alpha = 1.0f - abs(verticalOffset / appBarLayout.totalScrollRange.toFloat())
        })
    }
}
