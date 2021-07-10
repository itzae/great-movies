package com.itgonca.greatmovies.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

fun AppCompatImageView.loadImage(url: String) {
    if (url.isNotEmpty()) {
        Glide.with(this)
            .load(url)
            .into(this)
    }
}

fun<T> Fragment.asActivity() = (activity as T)
