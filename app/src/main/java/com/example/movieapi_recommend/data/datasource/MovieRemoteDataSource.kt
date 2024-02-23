package com.example.movieapi_recommend.data.datasource

import com.example.movieapi_recommend.data.model.Movie
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<Movie>
}