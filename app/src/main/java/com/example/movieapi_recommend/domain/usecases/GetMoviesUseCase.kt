package com.example.movieapi_recommend.domain.usecases

import com.example.movieapi_recommend.data.model.MovieItem
import com.example.movieapi_recommend.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository : MovieRepository) {
    suspend fun execute():List<MovieItem>? = movieRepository.getMovie()

}