package com.example.popularlibraries.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.popularlibraries.data.User
import io.reactivex.rxjava3.core.Single

@Dao
interface UserDao {
    @Query("SELECT * FROM github_users_table")
    fun getUsers(): Single<List<User>>

    @Query("SELECT * FROM github_users_table WHERE login LIKE :login LIMIT 1")
    fun getUserByLogin(login: String): Single<User>

    @Insert(onConflict = REPLACE)
    fun saveUser(user: User)

    @Insert(onConflict = REPLACE)
    fun saveUser(users: List<User>)
}