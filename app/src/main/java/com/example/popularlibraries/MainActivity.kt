package com.example.popularlibraries

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {
    private val navigator = AppNavigator(activity = this, R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.router.navigateTo(App.instance.screens.userScreen())
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }
}