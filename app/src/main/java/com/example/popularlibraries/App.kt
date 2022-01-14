package com.example.popularlibraries

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.popularlibraries.di.AppComponent
import com.example.popularlibraries.di.DaggerAppComponent

class App : Application() {

    lateinit var component: AppComponent

    @SuppressLint("StaticFieldLeak")
    object ContextHolder {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        ContextHolder.context = this
        instance = this

        component = DaggerAppComponent.builder()
            .setContext(this)
            .build()
    }

    companion object {
        lateinit var instance: App
    }

}