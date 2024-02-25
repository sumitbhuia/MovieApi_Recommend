package com.example.movieapi_recommend.presentation.injections

import com.example.movieapi_recommend.domain.usecases.GetMoviesUseCase
import com.example.movieapi_recommend.domain.usecases.UpdateMovieUseCase
import com.example.movieapi_recommend.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides
@Module
class MovieModule {
    @MovieScope
    @Provides
    fun providesMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ):ViewModelFactory{
        return ViewModelFactory(
            getMoviesUseCase,
            updateMovieUseCase
        )

    }
}