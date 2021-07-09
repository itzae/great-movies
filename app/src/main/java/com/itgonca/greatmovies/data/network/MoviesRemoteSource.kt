package com.itgonca.greatmovies.data.network

import com.itgonca.greatmovies.data.network.model.MovieResponse

interface MoviesRemoteSource {
    suspend fun getTrendingMovies():MovieResponse
}