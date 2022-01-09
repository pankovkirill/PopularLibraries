package com.example.popularlibraries.data

object GitHubUsersRepositoryFactory {
    fun create(): GitHubUserRepository = GitHubUsersRepositoryImpl()
}