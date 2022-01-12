package com.example.popularlibraries.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.popularlibraries.data.GitHubUser

@Database(entities = [GitHubUser::class], version = 1, exportSchema = false)
abstract class GitHubUserDB : RoomDatabase() {
    abstract fun getGitHubUserDao(): GitHubUserDao
}