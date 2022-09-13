package com.itgonca.greatmovies.features.components

import com.itgonca.greatmovies.R

sealed class Tab(val title: String, val icon: Int? = null) {
    object NowShowing : Tab("Now showing", R.drawable.ic_play)
    object ComingSoon : Tab("Coming soon", R.drawable.ic_watch)
}
