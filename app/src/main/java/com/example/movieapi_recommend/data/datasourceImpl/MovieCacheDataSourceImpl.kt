package com.example.movieapi_recommend.data.datasourceImpl

import com.example.movieapi_recommend.data.datasource.MovieCacheDataSource
import com.example.movieapi_recommend.data.model.Movie
import com.example.movieapi_recommend.data.model.MovieItem

class MovieCacheDataSourceImpl: MovieCacheDataSource {

    private var movieList = ArrayList<MovieItem>()
    override suspend fun getMovieFromCache(): List<MovieItem> = movieList

    override suspend fun saveMovieToCache(movies: List<MovieItem>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}