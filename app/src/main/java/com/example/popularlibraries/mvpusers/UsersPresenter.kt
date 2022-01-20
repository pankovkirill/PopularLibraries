package com.example.popularlibraries.mvpusers

import com.example.popularlibraries.data.*
import com.example.popularlibraries.data.repositories.UsersRepository
import com.example.popularlibraries.mvpuser.UserScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UsersPresenter :
    MvpPresenter<UsersView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var repository: UsersRepository

    @Inject
    lateinit var userConverter: UserConverter

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        updateUsersList()
    }

    fun showUserFragment(login: String) {
        router.navigateTo(UserScreen(login))
    }

    fun updateUsersList() {
        viewState.displayProgress(true)
        repository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { viewState.displayProgress(false) }
            .subscribe({ usersList ->
                viewState.showUsers(userConverter.convertUserListToUserItemList(usersList))
            }, { error: Throwable ->
                viewState.showError(error.message.toString(), true)
            })
    }
}