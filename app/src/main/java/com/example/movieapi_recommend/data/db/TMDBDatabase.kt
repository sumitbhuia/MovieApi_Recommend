package com.example.movieapi_recommend.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapi_recommend.data.model.MovieItem


@Database(entities = [MovieItem::class], version = 1, exportSchema = false)

abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao():MovieDAO

}

