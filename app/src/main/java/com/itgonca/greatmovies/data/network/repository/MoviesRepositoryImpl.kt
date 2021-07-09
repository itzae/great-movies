package com.itgonca.greatmovies.data.network.repository

import com.itgonca.greatmovies.data.network.MoviesRemoteSource
import com.itgonca.greatmovies.data.network.model.MovieResponse
import com.itgonca.greatmovies.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val moviesRemoteSource: MoviesRemoteSource) :
    MoviesRepository {
    override fun getTrendingMovies(): Flow<MovieResponse> = flow {
        emit(moviesRemoteSource.getTrendingMovies())
    }
}
