package com.example.movieapi_recommend.data.db


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapi_recommend.data.model.MovieItem



@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies:List<MovieItem>)

    @Query("DELETE FROM popular_movies")
    fun deleteAllMovies()


    @Query("SELECT * FROM popular_movies")
    fun getAllMovies():List<MovieItem>


}