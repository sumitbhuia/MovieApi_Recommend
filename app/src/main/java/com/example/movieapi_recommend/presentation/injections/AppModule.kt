package com.example.movieapi_recommend.presentation.injections

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun providesApplicationContext():Context{
        return context.applicationContext
    }
}
