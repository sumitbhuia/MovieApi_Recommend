package com.example.movieapi_recommend.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapi_recommend.domain.usecases.GetMoviesUseCase
import com.example.movieapi_recommend.domain.usecases.UpdateMovieUseCase

//We made the useCases , so that we don't deal with the repositories
//As we have made constructors , we need a factory to handle it.
class ViewModel (
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) :ViewModel()  {

    fun getMovie() = liveData {
        val movielist = getMoviesUseCase.execute()
        emit(movielist)
    }
    fun updateMovie() = liveData {
        val movielist = updateMovieUseCase.execute()
        emit(movielist)
    }
}