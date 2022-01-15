package com.example.popularlibraries.data.repositories

import com.example.popularlibraries.data.User
import com.example.popularlibraries.data.retrofit.GitHubApi
import com.example.popularlibraries.data.room.UserDao
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UsersRepositoryImpl
@Inject constructor(
    private val api: GitHubApi,
    private val dao: UserDao,
) : UsersRepository {


    override fun getUsers(): Single<List<User>> {
        return dao.getUsers()
            .flatMap {
                if (it.isEmpty()) {
                    api.fetchUsers()
                        .map { resultFromServer ->
                            dao.saveUser(resultFromServer)
                            resultFromServer
                        }
                } else {
                    Single.just(it)
                }
            }
    }

    override fun getUserDataByLogin(login: String): Single<User> =
        dao.getUserByLogin(login)
}