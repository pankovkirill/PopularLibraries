package com.example.popularlibraries.mvpuser.di

import com.example.popularlibraries.mvpuser.UserPresenter
import dagger.Subcomponent
import javax.inject.Scope

@UserFragmentScope
@Subcomponent(modules = [
    UserReposDaoModule::class,
    UsersReposRepositoryModule::class
])
interface UserFragmentComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): UserFragmentComponent
    }

    fun inject(userPresenter: UserPresenter)

}

@Scope
annotation class UserFragmentScope