package com.itgonca.greatmovies.data.network.api

import com.itgonca.greatmovies.BuildConfig
import com.itgonca.greatmovies.data.network.model.DetailResponse
import com.itgonca.greatmovies.data.network.model.GenreResponse
import com.itgonca.greatmovies.data.network.model.Movie
import com.itgonca.greatmovies.data.network.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    /**
     * This request get the daily or weekly trending items. The daily trending list tracks items
     * over the period of a day while items have a 24 hour half life. The weekly list tracks items
     * over a 7 day period, with a 7 day half life.
     * @param mediaType it is the type of content eg. movie,tv,etc.
     * @param timeWindow is the follow-up time eg. day,week,etc.
     * @return [MovieResponse]
     */
    @GET("trending/{media_type}/{time_window}")
    suspend fun trendingMovies(
        @Path("media_type") mediaType: String = "movie",
        @Path("time_window") timeWindow: String = "week",
        @Query("language") languaje: String
    ): MovieResponse<Movie>

    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("language") languaje: String
    ): GenreResponse


    @GET("discover/movie")
    suspend fun getCategories(
        @Query("with_genres") genreId: Int,
        @Query("language") languaje: String
    ): MovieResponse<Movie>

    /**
     * Get the primary information about a movie.
     * @param  movieId it is the id of the movie
     */
    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("language") languaje: String,
        @Query("append_to_response") appendResponse: String = "credits"
    ): DetailResponse
}