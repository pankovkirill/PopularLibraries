package com.example.popularlibraries.mvpusers

import moxy.MvpView
import com.example.popularlibraries.data.UserListItem
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface UsersView : MvpView {
    fun showUsers(users: List<UserListItem>)
    fun showError(message: String)
}