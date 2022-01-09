package com.example.popularlibraries.data

import io.reactivex.rxjava3.core.Single

interface GitHubUserRepository {
    fun getUsers(): Single<List<GitHubUser>>
    fun getUserDataByLogin(login: String): Single<GitHubUser>
}