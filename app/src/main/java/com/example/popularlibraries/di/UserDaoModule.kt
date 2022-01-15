package com.example.popularlibraries.di

import com.example.popularlibraries.data.room.MainDataBase
import dagger.Module
import dagger.Provides

@Module
class UserDaoModule {

    @Provides
    fun provideUserDao(db: MainDataBase) = db.getUserDao()

}