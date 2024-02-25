package com.example.movieapi_recommend.data.datasourceImpl

import com.example.movieapi_recommend.data.db.MovieDAO
import com.example.movieapi_recommend.data.datasource.MovieLocalDataSource
import com.example.movieapi_recommend.data.model.MovieItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//This class connects DAO interface (with function to work on local DB ) -> with Local  data source functions
//Basically giving life to the fn of local data source fn.
class MovieLocalDataSourceImpl(private val movieDAO: MovieDAO) : MovieLocalDataSource {
    override suspend fun getMovieFromDB(): List<MovieItem> = movieDAO.getAllMovies()
    override suspend fun saveMovieToDB(movies: List<MovieItem>) {
        CoroutineScope(Dispatchers.IO).launch{ movieDAO.saveMovies(movies) }
    }
    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch { movieDAO.deleteAllMovies() }
    }
}