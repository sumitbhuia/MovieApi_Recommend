package com.example.movieapi_recommend.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapi_recommend.data.model.MovieItem


@Database(entities = [MovieItem::class], version = 1, exportSchema = false)

abstract class TMDBDatabase : RoomDatabase() {


    //Edit all below
    abstract fun getMovieDAO(): MovieDAO

    companion object {
        @Volatile
        private var instance: TMDBDatabase? = null


        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            // instance ?:
            // createDatabase(context).also{
            // instance = it
        }
    }


    //Function create database
    // private fun createDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,TMDBDatabase::class.java,"movie_db").build()

    // }
}

