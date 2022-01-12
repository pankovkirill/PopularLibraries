package com.example.popularlibraries.data

import com.example.popularlibraries.data.retrofit.GitHubApiFactory
import com.example.popularlibraries.data.room.GitHubUserDBFactory
import io.reactivex.rxjava3.core.Single

class GitHubUsersRepositoryImpl : GitHubUserRepository {

    private val gitHubApi = GitHubApiFactory.create()
    private val gitHubUserDB = GitHubUserDBFactory.create().getGitHubUserDao()

    override fun getUsers(): Single<List<GitHubUser>> {
        return gitHubUserDB.getUsers()
            .flatMap {
                if (it.isEmpty()) {
                    gitHubApi.fetchUsers()
                        .map { resultFromServer ->
                            gitHubUserDB.saveUser(resultFromServer)
                            resultFromServer
                        }
                }
                else {
                    Single.just(it)
                }
            }
    }

    override fun getUserDataByLogin(login: String): Single<GitHubUser> =
        gitHubUserDB.getUserByLogin(login)
}