package com.example.popularlibraries.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.popularlibraries.data.UserReposEntity
import io.reactivex.rxjava3.core.Single

@Dao
interface UserReposDao {

    @Query("SELECT * FROM github_user_repos_table")
    fun getAllRepos(): Single<List<UserReposEntity>>

    @Query("SELECT * FROM github_user_repos_table WHERE login LIKE :login")
    fun getUserRepos(login: String): Single<List<UserReposEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUserRepo(repo: UserReposEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveUserRepo(repo: List<UserReposEntity>)

}