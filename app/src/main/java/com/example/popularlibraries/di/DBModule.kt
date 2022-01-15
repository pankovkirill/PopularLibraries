package com.example.popularlibraries.di

import android.content.Context
import androidx.room.Room
import com.example.popularlibraries.data.room.MainDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {

    @Singleton
    @Provides
    fun provideDB(context: Context): MainDataBase =
        Room.databaseBuilder(context, MainDataBase::class.java, "github_users.db").build()
}