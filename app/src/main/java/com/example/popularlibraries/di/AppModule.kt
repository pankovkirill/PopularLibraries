package com.example.popularlibraries.di

import dagger.Module

@Module(includes = [
        CiceroneModule::class,
        DBModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        UserConverterModule::class,
        UserDaoModule::class
    ]
)
class AppModule