package com.example.movieapi_recommend.presentation.injections

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component( modules =
   [ AppModule::class,
    CacheDataModule::class,
    DatabaseModule::class,
    LocalDataModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class
   ]
)
interface AppComponent {
    fun movieSubComponent():MovieSubComponent.Factory
}