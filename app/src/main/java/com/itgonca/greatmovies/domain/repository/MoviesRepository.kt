package com.itgonca.greatmovies.domain.repository

import com.itgonca.greatmovies.data.network.model.MovieResponse
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getTrendingMovies(): Flow<MovieResponse>
}