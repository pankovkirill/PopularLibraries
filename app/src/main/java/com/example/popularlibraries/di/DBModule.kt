package com.example.popularlibraries.di

import android.content.Context
import android.provider.DocumentsContract
import androidx.room.Room
import com.example.popularlibraries.data.room.GitHubUserDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {

    @Singleton
    @Provides
    fun provideDB(context: Context): GitHubUserDB =
        Room.databaseBuilder(context, GitHubUserDB::class.java, "github_users.db").build()
}