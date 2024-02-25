package com.example.movieapi_recommend.presentation.injections

import com.example.movieapi_recommend.data.datasource.MovieCacheDataSource
import com.example.movieapi_recommend.data.datasource.MovieLocalDataSource
import com.example.movieapi_recommend.data.datasource.MovieRemoteDataSource
import com.example.movieapi_recommend.domain.repository.MovieRepository
import com.example.movieapi_recommend.domain.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesMovieRepository(
        movieCacheDataSource: MovieCacheDataSource,
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource
    ):MovieRepository{
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )

    }
}