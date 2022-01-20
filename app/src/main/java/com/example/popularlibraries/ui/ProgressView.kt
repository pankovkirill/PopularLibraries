package com.example.popularlibraries.ui

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface ProgressView: MvpView {
    fun showError(message: String, tumbler: Boolean)
    fun displayProgress(tumbler: Boolean)
}