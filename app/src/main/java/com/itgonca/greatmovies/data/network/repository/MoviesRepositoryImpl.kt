package com.itgonca.greatmovies.data.network.repository

import com.itgonca.greatmovies.data.network.MoviesRemoteSource
import com.itgonca.greatmovies.data.network.model.GenreResponse
import com.itgonca.greatmovies.data.network.model.Movie
import com.itgonca.greatmovies.data.network.model.MovieResponse
import com.itgonca.greatmovies.domain.model.CategoryDto
import com.itgonca.greatmovies.domain.model.DetailDto
import com.itgonca.greatmovies.domain.model.toDetailMovie
import com.itgonca.greatmovies.domain.model.toMoviePoster
import com.itgonca.greatmovies.domain.repository.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesRemoteSource: MoviesRemoteSource,
    private val dispatcher: CoroutineDispatcher
) :
    MoviesRepository {
    override fun getTrendingMovies(): Flow<MovieResponse<Movie>> = flow {
        emit(moviesRemoteSource.getTrendingMovies())
    }.flowOn(dispatcher)

    override fun getGenreById(genreId: Int): Flow<MovieResponse<Movie>> = flow {
        emit(moviesRemoteSource.getGenreById(genreId))
    }.flowOn(dispatcher)

    override fun getGenres(): Flow<GenreResponse> = flow {
        emit(moviesRemoteSource.getGenre())
    }.flowOn(dispatcher)

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
    }.flowOn(dispatcher)

    override fun getMovieDetail(movieId: Int): Flow<DetailDto> = flow {
        val result = moviesRemoteSource.getMovieDetail(movieId).toDetailMovie()
        emit(result)
    }.flowOn(dispatcher)
}
