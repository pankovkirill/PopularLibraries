package com.example.popularlibraries.di

import android.content.Context
import com.example.popularlibraries.MainActivity
import com.example.popularlibraries.mvpuser.UserPresenter
import com.example.popularlibraries.mvpusers.UsersPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    CiceroneModule::class,
    DBModule::class,
    NetworkModule::class,
    RepositoryModule::class,
    UserConverterModule::class
])

interface AppComponent {
    @Component.Builder
    interface Builder{

        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(userPresenter: UserPresenter)
    fun inject(usersPresenter: UsersPresenter)
}