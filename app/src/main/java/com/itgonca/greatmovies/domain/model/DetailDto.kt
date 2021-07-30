package com.itgonca.greatmovies.domain.model

import com.itgonca.greatmovies.data.network.model.DetailResponse
import com.itgonca.greatmovies.data.network.model.Genre
import com.itgonca.greatmovies.data.network.model.ProductionCountry

data class DetailDto(
    val movieId: Int,
    val title: String,
    val genres: List<Genre>,
    val overview: String,
    val language: String,
    val backdropImage: String,
    val posterImage: String,
    val productionCountry: List<ProductionCountry>,
    val tagLine: String,
    val voteAverage: Double,
    val voteCount: Int,
    val castList: List<CastDto>
)

fun DetailResponse.toDetailMovie() = DetailDto(
    id,
    title,
    genres,
    overview,
    originalLanguage,
    backdropPath,
    posterPath ?: "",
    productionCountries,
    tagline,
    voteAverage,
    voteCount,
    credits.cast.filter { it.knownForDepartment == "Acting" }.map { cast -> cast.toCastDto() }
)