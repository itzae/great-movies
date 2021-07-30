package com.itgonca.greatmovies.utils

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.ColorUtils
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import java.util.*

fun AppCompatImageView.loadImage(url: String, imageError: Int? = null) {
    if (url.isNotEmpty()) {
        Glide.with(this)
            .load(url)
            .error(imageError)
            .into(this)
    }
}


fun <T> Fragment.asActivity() = (activity as T)


fun getContrastColor(@ColorInt colorSelected: Int): Int {
    val whiteContrast = ColorUtils.calculateContrast(Color.WHITE, colorSelected)
    val blackContrast = ColorUtils.calculateContrast(Color.BLACK, colorSelected)

    return if (whiteContrast > blackContrast) Color.WHITE else Color.BLACK
}

fun randomColor(): Int {
    val random = Random()
    return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
}
