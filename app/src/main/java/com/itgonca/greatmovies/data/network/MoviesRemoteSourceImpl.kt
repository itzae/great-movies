package com.itgonca.greatmovies.data.network

import com.itgonca.greatmovies.data.network.api.MoviesApi
import com.itgonca.greatmovies.data.network.model.MovieResponse
import javax.inject.Inject

class MoviesRemoteSourceImpl @Inject constructor(private val moviesApi: MoviesApi) :
    MoviesRemoteSource {
    override suspend fun getTrendingMovies(): MovieResponse = moviesApi.trendingMovies()
}