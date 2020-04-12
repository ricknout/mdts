package io.material.mdts

import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment

fun Fragment.openDrawer() = requireActivity().findViewById<DrawerLayout>(R.id.drawer).openDrawer(GravityCompat.START)
