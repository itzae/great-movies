package com.itgonca.greatmovies.di

import com.itgonca.greatmovies.data.database.MovieLocalSource
import com.itgonca.greatmovies.data.database.MovieLocalSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieLocalSourceModule {

    @Binds
    abstract fun providerMoviesLocalSource(movieLocalSourceImpl: MovieLocalSourceImpl): MovieLocalSource
}