package com.itgonca.greatmovies.data.network.model


import com.google.gson.annotations.SerializedName

data class MovieResponse<out T>(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<T>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)