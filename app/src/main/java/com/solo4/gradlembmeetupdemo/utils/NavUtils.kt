package com.solo4.gradlembmeetupdemo.utils

import androidx.fragment.app.Fragment
import com.solo4.gradlembmeetupdemo.R
import com.solo4.gradlembmeetupdemo.presentation.screens.friends.FriendsFragment
import com.solo4.gradlembmeetupdemo.presentation.screens.profile.ProfileFragment

fun Fragment.navigate(route: Route) {
    parentFragmentManager.beginTransaction()
        .replace(R.id.fragment_container_main, route.fragmentClass, null, null)
        .addToBackStack(route.fragmentClass.name)
        .commit()
}

sealed interface Route {

    val fragmentClass: Class<out Fragment>

    data object ProfileRoute : Route {
        override val fragmentClass: Class<out Fragment> = ProfileFragment::class.java
    }

    data object FriendsRoute : Route {
        override val fragmentClass: Class<out Fragment> = FriendsFragment::class.java
    }
}