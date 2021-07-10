package com.itgonca.greatmovies.domain.repository

import com.itgonca.greatmovies.data.network.model.GenreResponse
import com.itgonca.greatmovies.data.network.model.Movie
import com.itgonca.greatmovies.data.network.model.MovieResponse
import com.itgonca.greatmovies.domain.model.CategoryDto
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getTrendingMovies(): Flow<MovieResponse<Movie>>
    fun getGenreById(genreId: Int): Flow<MovieResponse<Movie>>
    fun getGenres(): Flow<GenreResponse>
    fun getMoviesByGenre(): Flow<List<CategoryDto>>
}