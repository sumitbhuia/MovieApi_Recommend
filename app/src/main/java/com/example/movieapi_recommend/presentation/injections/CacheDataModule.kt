package com.example.movieapi_recommend.presentation.injections

import com.example.movieapi_recommend.data.datasource.MovieCacheDataSource
import com.example.movieapi_recommend.data.datasourceImpl.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

}
