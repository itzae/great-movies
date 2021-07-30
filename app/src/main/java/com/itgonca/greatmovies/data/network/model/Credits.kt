package com.itgonca.greatmovies.data.network.model

import com.google.gson.annotations.SerializedName

data class Credits(@SerializedName("cast") val cast: List<Cast>)