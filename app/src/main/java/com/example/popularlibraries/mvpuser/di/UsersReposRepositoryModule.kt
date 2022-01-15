package com.example.popularlibraries.mvpuser.di

import com.example.popularlibraries.data.repositories.UsersReposRepository
import com.example.popularlibraries.data.repositories.UsersReposRepositoryImpl
import com.example.popularlibraries.data.retrofit.GitHubApi
import com.example.popularlibraries.data.room.UserReposDao
import dagger.Module
import dagger.Provides

@Module
class UsersReposRepositoryModule {

    @UserFragmentScope
    @Provides
    fun provideUsersReposRepository(api: GitHubApi, dao: UserReposDao): UsersReposRepository {
        return UsersReposRepositoryImpl(api, dao)
    }
}