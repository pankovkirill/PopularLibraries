package com.example.popularlibraries.mvpuser.di

import com.example.popularlibraries.data.room.MainDataBase
import dagger.Module
import dagger.Provides

@Module
class UserReposDaoModule {

    @UserFragmentScope
    @Provides
    fun provideUserReposDao(db: MainDataBase) = db.getUserReposDao()
}