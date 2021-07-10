package com.itgonca.greatmovies.utils

sealed class StateUi<out T> {
    object Loading : StateUi<Nothing>()
    data class Success<out T : Any>(val data: T) : StateUi<T>()
    data class Error(val exception: Throwable) : StateUi<Nothing>()
}