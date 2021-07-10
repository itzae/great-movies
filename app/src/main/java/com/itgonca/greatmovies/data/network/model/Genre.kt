package com.itgonca.greatmovies.data.network.model

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id") val genreId:Int,
    @SerializedName("name") val name:String
)