package com.example.popularlibraries.mvpusers

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.popularlibraries.R
import moxy.MvpAppCompatFragment
import com.example.popularlibraries.data.GitHubUser
import com.example.popularlibraries.databinding.ViewUsersBinding
import moxy.ktx.moxyPresenter

class UsersFragment(
    private val user: GitHubUser
) : MvpAppCompatFragment(R.layout.view_users), UsersView {

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(user)
    }

    private lateinit var viewBinging: ViewUsersBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinging = ViewUsersBinding.bind(view)
    }


    companion object {
        fun newInstance(user: GitHubUser) = UsersFragment(user)
    }

    override fun setData(login: String, password: String) {
        viewBinging.userLogin.text = "$login - $password"
    }
}