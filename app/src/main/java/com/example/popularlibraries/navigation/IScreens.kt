package com.example.popularlibraries.navigation

import com.example.popularlibraries.data.GitHubUser
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun userScreen(): Screen
    fun usersScreen(user: GitHubUser): Screen
}