package com.example.movieapi_recommend.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapi_recommend.domain.usecases.GetMoviesUseCase
import com.example.movieapi_recommend.domain.usecases.UpdateMovieUseCase


class ViewModelFactory(private val getMoviesUseCase: GetMoviesUseCase, private val updateMovieUseCase: UpdateMovieUseCase
): ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return ViewModel(getMoviesUseCase, updateMovieUseCase) as T


    }
}