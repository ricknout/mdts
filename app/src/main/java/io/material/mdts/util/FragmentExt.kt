package io.material.mdts.util

import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import io.material.mdts.R

fun Fragment.openDrawer() = requireActivity().findViewById<DrawerLayout>(R.id.drawer).openDrawer(GravityCompat.START)
