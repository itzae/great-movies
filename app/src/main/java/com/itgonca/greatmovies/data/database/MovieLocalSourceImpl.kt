package com.itgonca.greatmovies.data.database

import com.itgonca.greatmovies.data.database.dao.MovieDao
import com.itgonca.greatmovies.data.database.entity.MovieEntity
import javax.inject.Inject

class MovieLocalSourceImpl @Inject constructor(private val movieDao: MovieDao) : MovieLocalSource {

    override suspend fun saveMovies(movies: List<MovieEntity>) = movieDao.insertAll(movies)
}