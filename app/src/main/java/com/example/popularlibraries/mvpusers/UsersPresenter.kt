package com.example.popularlibraries.mvpusers

import com.example.popularlibraries.data.GitHubUser
import moxy.MvpPresenter

class UsersPresenter(private val user: GitHubUser) : MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        viewState.setData(user.login, user.password)
    }
}