package com.example.movieapi_recommend.presentation.injections

import android.content.Context
import androidx.room.Dao
import androidx.room.Room
import com.example.movieapi_recommend.data.db.MovieDAO
import com.example.movieapi_recommend.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context):TMDBDatabase{
        return Room.databaseBuilder(context,
            TMDBDatabase::class.java,"tmdbClient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MovieDAO{
        return tmdbDatabase.getMovieDAO()
    }
}