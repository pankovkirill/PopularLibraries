package com.example.popularlibraries.mvpuser

import com.example.popularlibraries.App
import com.example.popularlibraries.data.GitHubUser
import com.example.popularlibraries.data.GitHubUserRepository
import com.example.popularlibraries.data.User
import com.example.popularlibraries.data.convertUserToUserDetail
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserPresenter(
    private val userLogin: String,
    private val repository: GitHubUserRepository,
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        showUserData(userLogin)
    }

    private fun showUserData(userLogin: String) {
        repository.getUserDataByLogin(userLogin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ user: GitHubUser ->
                viewState.showUserDetail(convertUserToUserDetail(user))
            }, { error: Throwable ->
                viewState.showError(error.message.toString())
            })
    }

}