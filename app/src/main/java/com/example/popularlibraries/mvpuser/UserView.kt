package com.example.popularlibraries.mvpuser

import com.example.popularlibraries.data.User
import moxy.MvpView
import com.example.popularlibraries.data.UserDetail
import com.example.popularlibraries.ui.ProgressView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface UserView : ProgressView {
    fun showUserDetail(user: UserDetail)
}