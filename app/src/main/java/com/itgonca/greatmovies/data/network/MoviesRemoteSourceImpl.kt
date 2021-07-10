package com.itgonca.greatmovies.data.network

import com.itgonca.greatmovies.data.network.api.MoviesApi
import com.itgonca.greatmovies.data.network.model.GenreResponse
import com.itgonca.greatmovies.data.network.model.Movie
import com.itgonca.greatmovies.data.network.model.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRemoteSourceImpl @Inject constructor(private val moviesApi: MoviesApi) :
    MoviesRemoteSource {
    override suspend fun getTrendingMovies(): MovieResponse<Movie> = moviesApi.trendingMovies()
    override suspend fun getGenreById(genreId: Int): MovieResponse<Movie> =
        moviesApi.getCategories(genreId = genreId)

    override suspend fun getGenre(): GenreResponse = moviesApi.getGenres()
}