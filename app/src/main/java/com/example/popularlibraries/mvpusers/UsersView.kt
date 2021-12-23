package com.example.popularlibraries.mvpusers

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import com.example.popularlibraries.data.GitHubUser
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView : MvpView {
    fun setData(login: String, password: String)
}