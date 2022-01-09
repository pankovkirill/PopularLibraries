package com.example.popularlibraries.mvpuser

import androidx.fragment.app.FragmentFactory
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import com.example.popularlibraries.data.GitHubUser
import com.example.popularlibraries.data.GitHubUserDetail
import com.github.terrakok.cicerone.androidx.FragmentScreen
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface UserView : MvpView {
    fun showUserDetail(user: GitHubUserDetail)
    fun showError(message: String)
}