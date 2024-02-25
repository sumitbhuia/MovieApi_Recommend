package com.example.movieapi_recommend.presentation.injections

import com.example.movieapi_recommend.data.api.TMDBService
import com.example.movieapi_recommend.data.datasource.MovieRemoteDataSource
import com.example.movieapi_recommend.data.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey : String) {

    @Singleton
    @Provides
    fun providesMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService,apiKey)
    }

}