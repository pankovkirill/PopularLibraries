package com.example.popularlibraries.mvpuser

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import com.example.popularlibraries.data.GitHubUser
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface UserView : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(message: String)

}