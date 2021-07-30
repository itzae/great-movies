package com.itgonca.greatmovies.domain.model

import com.itgonca.greatmovies.data.network.model.Cast

data class CastDto(val id: Int, val name: String, val image: String?, val character: String)

fun Cast.toCastDto() = CastDto(
    id,
    name,
    profilePath,
    character
)