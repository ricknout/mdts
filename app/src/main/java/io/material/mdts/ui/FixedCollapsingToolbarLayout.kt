package io.material.mdts.ui

import android.content.Context
import android.util.AttributeSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.CollapsingToolbarLayout

/**
 * Custom CollapsingToolbarLayout to fix issue of wrap_content children with fitSystemWindows=true
 * See: https://github.com/material-components/material-components-android/issues/520
 */
class FixedCollapsingToolbarLayout
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CollapsingToolbarLayout(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (ViewCompat.getFitsSystemWindows(this)) {
            val mode = MeasureSpec.getMode(heightMeasureSpec)
            val topInset = getTopSystemInset()

            if (mode == MeasureSpec.UNSPECIFIED && topInset > 0) {
                val hasFitsSystemWindowsFlagInChild = (0 until childCount)
                    .map { index -> getChildAt(index) }
                    .any { ViewCompat.getFitsSystemWindows(it) }
                if (hasFitsSystemWindowsFlagInChild) {
                    val heightSpec = MeasureSpec.makeMeasureSpec(measuredHeight - topInset, MeasureSpec.EXACTLY)
                    super.onMeasure(widthMeasureSpec, heightSpec)
                }
            }
        }
    }

    private fun getTopSystemInset(): Int {
        val field = CollapsingToolbarLayout::class.java.getDeclaredField("lastInsets")
            .apply { isAccessible = true }
        val windowsInsetsCompat = field.get(this) as? WindowInsetsCompat
        return windowsInsetsCompat?.systemWindowInsetTop ?: 0
    }
}
