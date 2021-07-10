package com.itgonca.greatmovies.domain.model

import com.itgonca.greatmovies.data.network.model.Movie

data class MoviePosterDto(val idMovie: Int, val pathImage: String)

fun Movie.toMoviePoster() = MoviePosterDto(id, posterPath ?: "")