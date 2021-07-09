package com.itgonca.greatmovies.data.network.api

import com.itgonca.greatmovies.BuildConfig
import com.itgonca.greatmovies.data.network.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface MoviesApi {

    /**
     * This request get the daily or weekly trending items. The daily trending list tracks items
     * over the period of a day while items have a 24 hour half life. The weekly list tracks items
     * over a 7 day period, with a 7 day half life.
     * @param mediaType it is the type of content eg. movie,tv,etc.
     * @param timeWindow is the follow-up time eg. day,week,etc.
     */
    @GET("trending/{media_type}/{time_window}")
    suspend fun trendingMovies(
        @Header("Authorization") apiToken: String = "Bearer ${BuildConfig.API_TOKEN}",
        @Path("media_type") mediaType: String = "movie",
        @Path("time_window") timeWindow: String = "week"
    ): MovieResponse
}