package com.example.movieapi_recommend.presentation.injections

import com.example.movieapi_recommend.MainActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }
}