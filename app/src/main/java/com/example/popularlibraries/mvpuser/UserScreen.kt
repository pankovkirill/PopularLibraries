package com.example.popularlibraries.mvpuser

import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class UserScreen(private val login: String) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory) =
        UserFragment.newInstance(login)
}