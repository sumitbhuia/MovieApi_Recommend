package com.example.movieapi_recommend.data.datasourceImpl

import com.example.movieapi_recommend.data.api.TMDBService
import com.example.movieapi_recommend.data.datasource.MovieRemoteDataSource
import com.example.movieapi_recommend.data.model.Movie
import retrofit2.Response


//This class connects Dao interface (with network transaction function ) -> with  Remote data source functions
//Basically giving life to the fn of remote data source fn.
class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService , private val apiKey : String) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<Movie> = tmdbService.getPopularMovies(apiKey)

}