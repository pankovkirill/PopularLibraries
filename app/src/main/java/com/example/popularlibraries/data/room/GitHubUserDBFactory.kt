package com.example.popularlibraries.data.room

import androidx.room.Room
import com.example.popularlibraries.App

object GitHubUserDBFactory {

    private val database: GitHubUserDB by lazy {
        Room.databaseBuilder(App.ContextHolder.context, GitHubUserDB::class.java, "github_users.db")
            .build()
    }

    fun create(): GitHubUserDB = database
}