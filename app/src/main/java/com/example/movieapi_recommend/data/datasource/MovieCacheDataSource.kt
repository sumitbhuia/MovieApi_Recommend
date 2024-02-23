package com.example.movieapi_recommend.data.datasource

import com.example.movieapi_recommend.data.model.MovieItem

interface MovieCacheDataSource {

    suspend fun getMovieFromCache():List<MovieItem>
    suspend fun saveMovieToCache(movies : List<MovieItem>)
}