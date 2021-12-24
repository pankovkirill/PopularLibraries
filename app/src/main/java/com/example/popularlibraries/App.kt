package com.example.popularlibraries

import android.app.Application
import com.example.popularlibraries.data.GitHubUsersRepository
import com.example.popularlibraries.navigation.AppScreens
import com.example.popularlibraries.navigation.IScreens
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }

    val screens: IScreens by lazy {
        AppScreens()
    }
    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val router get() = cicerone.router


    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    val githubUsersRepository by lazy { GitHubUsersRepository() }

}