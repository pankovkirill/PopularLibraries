package com.example.popularlibraries.data.repositories

import com.example.popularlibraries.data.User
import io.reactivex.rxjava3.core.Single

interface UsersRepository {
    fun getUsers(): Single<List<User>>
    fun getUserDataByLogin(login: String): Single<User>
}