package com.itgonca.greatmovies.domain.model

import com.itgonca.greatmovies.data.network.model.Movie

data class CategoryDto(val idCategory: Int, val name: String, val listMovie: List<MoviePosterDto>)
