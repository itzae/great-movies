package com.itgonca.greatmovies.data.database

import com.itgonca.greatmovies.data.database.entity.MovieEntity

interface MovieLocalSource {
    suspend fun saveMovies(movies: List<MovieEntity>)
}