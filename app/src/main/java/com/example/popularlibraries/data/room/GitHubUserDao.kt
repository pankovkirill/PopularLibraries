package com.example.popularlibraries.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.popularlibraries.data.GitHubUser
import io.reactivex.rxjava3.core.Single

@Dao
interface GitHubUserDao {

    @Query("SELECT * FROM github_users_table")
    fun getUsers(): Single<List<GitHubUser>>

    @Query("SELECT * FROM github_users_table WHERE login LIKE :login LIMIT 1")
    fun getUserByLogin(login: String): Single<GitHubUser>

    @Insert(onConflict = REPLACE)
    fun saveUser (user: GitHubUser)

    @Insert(onConflict = REPLACE)
    fun saveUser (users: List<GitHubUser>)

}