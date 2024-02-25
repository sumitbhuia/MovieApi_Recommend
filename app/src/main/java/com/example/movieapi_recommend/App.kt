package com.example.movieapi_recommend

import android.app.Application
import com.example.movieapi_recommend.presentation.injections.AppComponent
import com.example.movieapi_recommend.presentation.injections.AppModule
import com.example.movieapi_recommend.presentation.injections.DaggerAppComponent
import com.example.movieapi_recommend.presentation.injections.Injector
import com.example.movieapi_recommend.presentation.injections.MovieSubComponent
import com.example.movieapi_recommend.presentation.injections.NetModule
import com.example.movieapi_recommend.presentation.injections.RemoteDataModule

class App:Application(),Injector {
    private lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }
    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }
}