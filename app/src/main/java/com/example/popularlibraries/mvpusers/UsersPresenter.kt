package com.example.popularlibraries.mvpusers

import com.example.popularlibraries.App.Companion.router
import com.example.popularlibraries.data.*
import com.example.popularlibraries.mvpuser.UserScreen
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UsersPresenter(private val repository: GitHubUserRepository) :
    MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        updateUsersList()
    }

    fun showUserFragment(login: String) {
        router.navigateTo(UserScreen(login))
    }

    private fun updateUsersList() {
        repository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ usersList ->
                viewState.showUsers(convertUserListToUserItemList(usersList))
            }, { error: Throwable ->
                viewState.showError(error.message.toString())
            })
    }
}