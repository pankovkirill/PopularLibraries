package com.example.popularlibraries.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.popularlibraries.data.User
import com.example.popularlibraries.data.UserReposEntity

@Database(entities = [User::class, UserReposEntity::class], version = 1, exportSchema = false)

abstract class MainDataBase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getUserReposDao(): UserReposDao
}