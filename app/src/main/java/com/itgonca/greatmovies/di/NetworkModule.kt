package com.itgonca.greatmovies.di

import com.google.gson.GsonBuilder
import com.itgonca.greatmovies.BuildConfig
import com.itgonca.greatmovies.data.network.api.MoviesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providerBuildRetrofit(httpClient: OkHttpClient.Builder, gson: GsonBuilder): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson.create()))
            .client(httpClient.build())
            .build()

    @Singleton
    @Provides
    fun providerGsonBuilder(): GsonBuilder = GsonBuilder()

    @Singleton
    @Provides
    fun providerHttpClient() =
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) level = HttpLoggingInterceptor.Level.BODY
        })

    @Singleton
    @Provides
    fun providerMovieService(builder: Retrofit): MoviesApi = builder.create(MoviesApi::class.java)

}