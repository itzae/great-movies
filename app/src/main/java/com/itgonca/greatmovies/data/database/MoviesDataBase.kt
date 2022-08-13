package com.itgonca.greatmovies.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.itgonca.greatmovies.data.database.dao.MovieDao
import com.itgonca.greatmovies.data.database.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MoviesDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}