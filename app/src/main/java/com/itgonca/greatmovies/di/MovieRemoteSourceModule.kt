package com.itgonca.greatmovies.di

import com.itgonca.greatmovies.data.network.MoviesRemoteSource
import com.itgonca.greatmovies.data.network.MoviesRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.*
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieRemoteSourceModule {


    @Binds
    abstract fun providerMovieRemoteSource(movieRemoteSource: MoviesRemoteSourceImpl): MoviesRemoteSource

}