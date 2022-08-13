package com.itgonca.greatmovies.di

import android.content.Context
import androidx.room.Room
import com.itgonca.greatmovies.data.database.MoviesDataBase
import com.itgonca.greatmovies.data.database.dao.MovieDao
import com.itgonca.greatmovies.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MoviesDataBase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideMovieDao(db: MoviesDataBase): MovieDao = db.movieDao()
}