package com.itgonca.greatmovies.data.network

import com.itgonca.greatmovies.data.network.api.MoviesApi
import com.itgonca.greatmovies.data.network.model.DetailResponse
import com.itgonca.greatmovies.data.network.model.GenreResponse
import com.itgonca.greatmovies.data.network.model.Movie
import com.itgonca.greatmovies.data.network.model.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class MoviesRemoteSourceImpl @Inject constructor(
    private val moviesApi: MoviesApi,
    @Named("languajeDevice") private val language: String
) :
    MoviesRemoteSource {
    override suspend fun getTrendingMovies(): MovieResponse<Movie> = moviesApi.trendingMovies(languaje = language)

    override suspend fun getGenreById(genreId: Int): MovieResponse<Movie> =
        moviesApi.getCategories(genreId = genreId, languaje = language)

    override suspend fun getGenre(): GenreResponse = moviesApi.getGenres(languaje = language)

    override suspend fun getMovieDetail(movieId: Int): DetailResponse =
        moviesApi.getMovieDetail(movieId = movieId, languaje = language)
}