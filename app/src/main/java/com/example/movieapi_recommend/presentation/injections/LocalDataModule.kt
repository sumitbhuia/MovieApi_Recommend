package com.example.movieapi_recommend.presentation.injections

import com.example.movieapi_recommend.data.datasource.MovieLocalDataSource
import com.example.movieapi_recommend.data.datasourceImpl.MovieLocalDataSourceImpl
import com.example.movieapi_recommend.data.db.MovieDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun providesMovieLocalDataSource(movieDAO: MovieDAO): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDAO)
    }

}