package com.example.popularlibraries.data.retrofit

import com.example.popularlibraries.data.GitHubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    @GET("/users")
    fun fetchUsers(): Single<List<GitHubUser>>
}