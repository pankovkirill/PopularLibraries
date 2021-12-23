package com.example.popularlibraries.navigation

import com.example.popularlibraries.data.GitHubUser
import com.example.popularlibraries.mvpuser.UserFragment
import com.example.popularlibraries.mvpusers.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AppScreens : IScreens {

    override fun userScreen() = FragmentScreen {
        UserFragment.newInstance()
    }

    override fun usersScreen(user: GitHubUser) = FragmentScreen {
        UsersFragment.newInstance(user)
    }
}