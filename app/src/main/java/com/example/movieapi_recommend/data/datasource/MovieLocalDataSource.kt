package com.example.movieapi_recommend.data.datasource

import com.example.movieapi_recommend.data.model.Movie
import com.example.movieapi_recommend.data.model.MovieItem
import retrofit2.Response

interface MovieLocalDataSource {

    suspend fun getMovieFromDB():List<MovieItem>
    suspend fun saveMovieToDB(movies : List<MovieItem>)

    suspend fun clearAll()

}