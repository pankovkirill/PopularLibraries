package com.example.popularlibraries.mvpusers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibraries.App
import moxy.MvpAppCompatFragment
import com.example.popularlibraries.data.UserListItem
import com.example.popularlibraries.databinding.FragmentUsersBinding
import com.example.popularlibraries.recycler.UsersAdapter
import com.example.popularlibraries.ui.ProgressFragment
import moxy.ktx.moxyPresenter


class UsersFragment : ProgressFragment(), UsersView, UsersAdapter.OnItemClickListener {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    private val adapter = UsersAdapter(this)

    private val presenter by moxyPresenter {
        UsersPresenter().apply {
            App.instance.component.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.fragmentUsersRecyclerView

        recyclerView.let { rv ->
            rv.adapter = adapter
            rv.layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun showUsers(users: List<UserListItem>) {
        hideAll()
        adapter.setUsers(users)
    }

    override fun showError(message: String, tumbler: Boolean) {
        changeViewVisibility(binding.usersFragmentErrorContainer, tumbler)
        if (tumbler) {
            binding.usersFragmentErrorMessage.text = message
            binding.usersFragmentTryAgainButton.setOnClickListener {
                hideAll()
                displayProgress(true)
                presenter.updateUsersList()
            }
        }
    }

    override fun displayProgress(tumbler: Boolean) {
        changeViewVisibility(binding.usersFragmentProgressBar, tumbler)
    }

    private fun hideAll() {
        changeViewVisibility(binding.usersFragmentErrorContainer, false)
        changeViewVisibility(binding.usersFragmentProgressBar, false)
    }

    override fun onUserClick(user: UserListItem) {
        presenter.showUserFragment(user.login)
    }
}