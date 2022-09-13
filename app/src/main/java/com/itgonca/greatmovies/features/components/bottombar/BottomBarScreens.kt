package com.itgonca.greatmovies.features.components.bottombar

import com.itgonca.greatmovies.R

sealed class BottomBarScreens(val route: String, val title: String, val icon: Int) {
    object Home : BottomBarScreens(
        route = "home",
        title = "home",
        icon = R.drawable.ic_movie_reel
    )

    object Event : BottomBarScreens(
        route = "event",
        title = "event",
        icon = R.drawable.ic_event_ticket
    )

    object Notification : BottomBarScreens(
        route = "notification",
        title = "notification",
        icon = R.drawable.ic_notification
    )

    object Profile: BottomBarScreens(
        route = "profile",
        title = "profile",
        icon = R.drawable.ic_profile
    )
}
