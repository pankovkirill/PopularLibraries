package com.example.popularlibraries.data.repositories

import com.example.popularlibraries.data.UserReposEntity
import io.reactivex.rxjava3.core.Single

interface UsersReposRepository {
    fun getUserRepos(login: String): Single<List<UserReposEntity>>
}