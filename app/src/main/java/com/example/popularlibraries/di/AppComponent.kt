package com.example.popularlibraries.di

import android.content.Context
import com.example.popularlibraries.MainActivity
import com.example.popularlibraries.mvpuser.UserPresenter
import com.example.popularlibraries.mvpuser.di.UserFragmentComponent
import com.example.popularlibraries.mvpusers.UsersPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])

interface AppComponent {

    fun provideUserFragmentComponent(): UserFragmentComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(usersPresenter: UsersPresenter)
}