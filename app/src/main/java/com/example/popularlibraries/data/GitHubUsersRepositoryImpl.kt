package com.example.popularlibraries.data

import com.example.popularlibraries.data.retrofit.GitHubApiFactory
import io.reactivex.rxjava3.core.Single

class GitHubUsersRepositoryImpl : GitHubUserRepository {

    private val gitHubApi = GitHubApiFactory.create()

    override fun getUsers() = gitHubApi.fetchUsers()

    override fun getUserDataByLogin(login: String): Single<GitHubUser> =
        gitHubApi.fetchUserDataByLogin(login)
}