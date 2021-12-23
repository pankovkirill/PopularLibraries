package com.example.popularlibraries.mvpuser

import com.example.popularlibraries.App
import com.example.popularlibraries.data.GitHubUser
import moxy.MvpPresenter

class UserPresenter() : MvpPresenter<UserView>() {

    private val router by lazy { App.instance.router }
    private val screens by lazy { App.instance.screens }

    fun register(login: String, password: String) {
        if (isLoginValid(login) && isPasswordValid(password)) {
            val user = GitHubUser(login, password)
            showUsersFragment(user)
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