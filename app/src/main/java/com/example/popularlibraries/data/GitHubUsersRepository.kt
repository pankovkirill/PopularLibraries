package com.example.popularlibraries.data

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer

class GitHubUsersRepository {

    private val users = listOf<GitHubUser>(
        GitHubUser("login1", "11111"),
        GitHubUser("login2", "22222"),
        GitHubUser("login3", "33333"),
        GitHubUser("login4", "44444"),
        GitHubUser("login5", "55555"),
    )

    fun getUserByLogin(login: String): Observable<GitHubUser> {
        return Observable.fromIterable(users)
            .distinct()
            .filter {
                it.login == login
            }
    }
}