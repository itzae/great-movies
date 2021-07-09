package com.itgonca.greatmovies.di

import com.itgonca.greatmovies.data.network.MoviesRemoteSource
import com.itgonca.greatmovies.data.network.MoviesRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieRemoteSourceModule {


    @Binds
    abstract fun providerMovieRemoteSource(movieRemoteSource:MoviesRemoteSourceImpl):MoviesRemoteSource
}