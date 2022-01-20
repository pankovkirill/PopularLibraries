package com.example.popularlibraries.mvpusers

import moxy.MvpView
import com.example.popularlibraries.data.UserListItem
import com.example.popularlibraries.ui.ProgressView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface UsersView : ProgressView {
    fun showUsers(users: List<UserListItem>)
}