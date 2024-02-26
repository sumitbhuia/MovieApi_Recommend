package com.example.movieapi_recommend.domain.repository

import com.example.movieapi_recommend.data.model.MovieItem

interface MovieRepository{

    suspend fun getMovie() : List<MovieItem>?
    suspend fun updateMovies():List<MovieItem>?

}