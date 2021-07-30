package com.itgonca.greatmovies.di

import com.itgonca.greatmovies.data.network.repository.MoviesRepositoryImpl
import com.itgonca.greatmovies.domain.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieRepositoryModule {

    @Binds
    abstract fun provideMovieRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository
}