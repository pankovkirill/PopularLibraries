package com.example.popularlibraries.mvpusers

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import com.example.popularlibraries.data.GitHubUser
import com.example.popularlibraries.data.GitHubUserListItem
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface UsersView : MvpView {
    fun showUsers(users: List<GitHubUserListItem>)
    fun showError(message: String)
}