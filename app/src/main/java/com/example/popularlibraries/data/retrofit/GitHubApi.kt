package com.example.popularlibraries.data.retrofit

import com.example.popularlibraries.data.User
import com.example.popularlibraries.data.UserReposData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    @GET("/users")
    fun fetchUsers(): Single<List<User>>

    @GET("/users/{login}")
    fun fetchUserDataByLogin(@Path("login") login: String): Single<User>

    @GET("/users/{login}/repos")
    fun fetchUserRepositories(@Path("login") login: String): Single<List<UserReposData>>
}