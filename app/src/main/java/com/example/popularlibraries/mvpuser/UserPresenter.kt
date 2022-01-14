package com.example.popularlibraries.mvpuser

import com.example.popularlibraries.data.GitHubUser
import com.example.popularlibraries.data.GitHubUserRepository
import com.example.popularlibraries.data.UserConverter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UserPresenter(
    private val userLogin: String,
) : MvpPresenter<UserView>() {

    @Inject
    lateinit var repository: GitHubUserRepository

    @Inject
    lateinit var userConverter: UserConverter

    override fun onFirstViewAttach() {
        showUserData(userLogin)
    }

    private fun showUserData(userLogin: String) {
        repository.getUserDataByLogin(userLogin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ user: GitHubUser ->
                viewState.showUserDetail(userConverter.convertUserToUserDetail(user))
            }, { error: Throwable ->
                viewState.showError(error.message.toString())
            })
    }

}