package com.itgonca.greatmovies.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.itgonca.greatmovies.data.network.model.Movie

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey val idMovie: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "mediaType") val mediaType: String,
    @ColumnInfo(name = "original_name") val originalName: String,
    @ColumnInfo(name = "original_title") val originalTitle: String,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "popularity") val popularity: Double,
    @ColumnInfo(name = "poster_path") val posterPath: String,
    @ColumnInfo(name = "release_date") val releaseDate: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "video") val video: Boolean,
    @ColumnInfo(name = "vote_average") val voteAverage: Double,
    @ColumnInfo(name = "vote_count") val voteCount: Int,
)
fun Movie.toMovieEntity() = MovieEntity(
    idMovie = id,
    name = name ?: "",
    mediaType = mediaType ?: "",
    originalName = originalName ?: "",
    originalTitle = originalTitle ?:"",
    overview = overview ?:"",
    popularity = popularity ?: 0.0,
    posterPath = posterPath ?: "",
    releaseDate = releaseDate ?: "",
    title = title ?: "",
    video = video ?: false,
    voteAverage = voteAverage ?: 0.0,
    voteCount = voteCount ?: 0
)