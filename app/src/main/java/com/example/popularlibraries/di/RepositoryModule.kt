package com.example.popularlibraries.di

import com.example.popularlibraries.data.GitHubUserRepository
import com.example.popularlibraries.data.GitHubUsersRepositoryImpl
import com.example.popularlibraries.data.retrofit.GitHubApi
import com.example.popularlibraries.data.room.GitHubUserDB
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class RepositoryModule {

    @Reusable
    @Provides
    fun provideRepository(api: GitHubApi, db: GitHubUserDB): GitHubUserRepository = GitHubUsersRepositoryImpl(api, db)
}