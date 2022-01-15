package com.example.popularlibraries.mvpuser

import moxy.MvpView
import com.example.popularlibraries.data.UserDetail
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface UserView : MvpView {
    fun showUserDetail(user: UserDetail)
    fun showError(message: String)
}