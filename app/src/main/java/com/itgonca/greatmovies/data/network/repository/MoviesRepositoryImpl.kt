package com.itgonca.greatmovies.data.network.repository

import com.itgonca.greatmovies.data.network.MoviesRemoteSource
import com.itgonca.greatmovies.data.network.model.GenreResponse
import com.itgonca.greatmovies.data.network.model.Movie
import com.itgonca.greatmovies.data.network.model.MovieResponse
import com.itgonca.greatmovies.domain.model.CategoryDto
import com.itgonca.greatmovies.domain.model.toMoviePoster
import com.itgonca.greatmovies.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val moviesRemoteSource: MoviesRemoteSource) :
    MoviesRepository {
    override fun getTrendingMovies(): Flow<MovieResponse<Movie>> = flow {
        emit(moviesRemoteSource.getTrendingMovies())
    }

    override fun getGenreById(genreId: Int): Flow<MovieResponse<Movie>> = flow {
        emit(moviesRemoteSource.getGenreById(genreId))
    }

    override fun getGenres(): Flow<GenreResponse> = flow {
        emit(moviesRemoteSource.getGenre())
    }

    override fun getMoviesByGenre(): Flow<List<CategoryDto>> = flow {

        val genres = withContext(Dispatchers.IO) { moviesRemoteSource.getGenre() }
        val moviesByGenres = withContext(Dispatchers.IO) {
            genres.genres.map { genre ->
                CategoryDto(
                    genre.genreId,
                    genre.name,
                    moviesRemoteSource.getGenreById(genre.genreId).results.map {
                        it.toMoviePoster()
                    })
            }
        }

        emit(moviesByGenres)
    }
}
