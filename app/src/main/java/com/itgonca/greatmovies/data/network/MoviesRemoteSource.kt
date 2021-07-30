package com.itgonca.greatmovies.data.network

import com.itgonca.greatmovies.data.network.model.DetailResponse
import com.itgonca.greatmovies.data.network.model.GenreResponse
import com.itgonca.greatmovies.data.network.model.Movie
import com.itgonca.greatmovies.data.network.model.MovieResponse

interface MoviesRemoteSource {
    suspend fun getTrendingMovies(): MovieResponse<Movie>
    suspend fun getGenreById(genreId: Int): MovieResponse<Movie>
    suspend fun getGenre(): GenreResponse
    suspend fun getMovieDetail(movieId:Int): DetailResponse
}