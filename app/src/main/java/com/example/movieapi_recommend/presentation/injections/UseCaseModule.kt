package com.example.movieapi_recommend.presentation.injections

import com.example.movieapi_recommend.domain.repository.MovieRepository
import com.example.movieapi_recommend.domain.usecases.GetMoviesUseCase
import com.example.movieapi_recommend.domain.usecases.UpdateMovieUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providesMovieUseCases(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun providesUpdateMovieUseCases(movieRepository: MovieRepository): UpdateMovieUseCase {
        return UpdateMovieUseCase(movieRepository)
    }
}