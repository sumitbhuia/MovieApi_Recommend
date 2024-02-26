package com.example.movieapi_recommend.domain.repository

import com.example.movieapi_recommend.data.datasource.MovieCacheDataSource
import com.example.movieapi_recommend.data.datasource.MovieLocalDataSource
import com.example.movieapi_recommend.data.datasource.MovieRemoteDataSource
import com.example.movieapi_recommend.data.model.MovieItem


class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovie(): List<MovieItem> {
        return getMoviesFromCache()
    }
    override suspend fun updateMovies(): List<MovieItem> {
       val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovieToDB(newListOfMovies)
        movieCacheDataSource.saveMovieToCache(newListOfMovies)

        return newListOfMovies

    }
    suspend fun getMoviesFromAPI(): List<MovieItem> {
        lateinit var movies : List<MovieItem>

        try {
            val response = movieRemoteDataSource.getMovies()

            //Making a variable that resembles body of response<list>
            val body = response.body()
            // If response body not empty
            if(body!=null){
                // store all the available list of movies win movies , from response body
                movies = body.movieList
            }

        }catch (exception:Exception){

            //Logcat
        }
        return movies

    }
    suspend fun getMoviesFromROOM():List<MovieItem>{
        lateinit var movies : List<MovieItem>

        //Store what ever data available from local DB to movies and the check fo if , else
        try {
            movies = movieLocalDataSource.getMovieFromDB()
        }catch (exception:Exception){

        }
        // If list is not empty , return list
        if(movies.isNotEmpty()){
            return movies
        }
        // Otherwise fetch from api , save it to local DB , and then return by default
        else{
            movies=getMoviesFromAPI()
            movieLocalDataSource.saveMovieToDB(movies)
        }
        return movies
    }
    private suspend fun getMoviesFromCache(): List<MovieItem> {
        lateinit var movies : List<MovieItem>
        try {
            movies = movieCacheDataSource.getMovieFromCache()
        }catch (exception:Exception){
            //Logcat
        }
        if(movies.isNotEmpty()){
            return movies
        }
        else{
            movies = getMoviesFromROOM()
            movieCacheDataSource.saveMovieToCache(movies)
        }
        return movies


    }
}