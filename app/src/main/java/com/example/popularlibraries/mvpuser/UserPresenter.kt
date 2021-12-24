package com.example.popularlibraries.mvpuser

import com.example.popularlibraries.App
import com.example.popularlibraries.data.GitHubUser
import moxy.MvpPresenter

class UserPresenter() : MvpPresenter<UserView>() {

    private val router by lazy { App.instance.router }
    private val screens by lazy { App.instance.screens }
    private val repository by lazy { App.instance.githubUsersRepository }

    fun register(login: String, password: String) {
        if (isLoginValid(login) && isPasswordValid(password)) {
            repository.getUserByLogin(login).subscribe { user ->
                checkPassword(user, password)
            }
        }
    }

    private fun checkPassword(user: GitHubUser, password: String) {
        if (user.password == password) {
            showUsersFragment(user)
        } else{
            viewState.showError("Wrong password")
        }
    }

    private fun showUsersFragment(user: GitHubUser) {
        router.navigateTo(screens.usersScreen(user))
    }

    private fun isPasswordValid(password: String) = when {
        password.isEmpty() -> {
            viewState.showError("Password is empty")
            false
        }
        password.length < 3 -> {
            viewState.showError("Password too short")
            false
        }
        else -> true
    }

    private fun isLoginValid(login: String) = when {
        login.isEmpty() -> {
            viewState.showError("Login is empty")
            false
        }
        login.length < 3 -> {
            viewState.showError("Login too short")
            false
        }
        else -> true
    }
}