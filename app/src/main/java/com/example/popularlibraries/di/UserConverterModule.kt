package com.example.popularlibraries.di

import com.example.popularlibraries.data.UserConverter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserConverterModule {

    @Singleton
    @Provides
    fun provideUserConverter() = UserConverter()
}