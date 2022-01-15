package com.example.popularlibraries.di

import com.example.popularlibraries.data.repositories.UsersRepository
import com.example.popularlibraries.data.repositories.UsersRepositoryImpl
import com.example.popularlibraries.data.retrofit.GitHubApi
import com.example.popularlibraries.data.room.UserDao
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class RepositoryModule {

    @Reusable
    @Provides
    fun provideRepository(api: GitHubApi, dao: UserDao): UsersRepository = UsersRepositoryImpl(api, dao)
}