package com.example.popularlibraries.data

import com.example.popularlibraries.data.retrofit.GitHubApi
import com.example.popularlibraries.data.room.GitHubUserDB
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GitHubUsersRepositoryImpl
@Inject constructor(
    private val gitHubApi: GitHubApi,
    private val gitHubUserDB: GitHubUserDB
) : GitHubUserRepository {

    override fun getUsers(): Single<List<GitHubUser>> {
        return gitHubUserDB.getGitHubUserDao().getUsers()
            .flatMap {
                if (it.isEmpty()) {
                    gitHubApi.fetchUsers()
                        .map { resultFromServer ->
                            gitHubUserDB.getGitHubUserDao().saveUser(resultFromServer)
                            resultFromServer
                        }
                } else {
                    Single.just(it)
                }
            }
    }

    override fun getUserDataByLogin(login: String): Single<GitHubUser> =
        gitHubUserDB.getGitHubUserDao().getUserByLogin(login)
}