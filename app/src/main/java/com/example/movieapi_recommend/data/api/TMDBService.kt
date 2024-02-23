package com.example.movieapi_recommend.data.api

import com.example.movieapi_recommend.data.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//Holds all functions important for network transactions , like @GET
interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        //Suspend fun gets popular movie , as input it takes a @Query -> it takes key "api_key" ,
        // query variable name is apiKey
        // and returns the query result in movies array
        @Query("api_key") apiKey: String): Response<Movie>



}