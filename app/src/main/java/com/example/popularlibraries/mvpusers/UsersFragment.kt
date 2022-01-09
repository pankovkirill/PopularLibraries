package com.example.popularlibraries.mvpusers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import com.example.popularlibraries.data.GitHubUserListItem
import com.example.popularlibraries.data.GitHubUsersRepositoryFactory
import com.example.popularlibraries.databinding.FragmentUsersBinding
import com.example.popularlibraries.recycler.UsersAdapter
import moxy.ktx.moxyPresenter


class UsersFragment : MvpAppCompatFragment(), UsersView, UsersAdapter.OnItemClickListener {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    private val repository = GitHubUsersRepositoryFactory.create()
    private val adapter = UsersAdapter(this)

    private val presenter by moxyPresenter {
        UsersPresenter(repository)
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

    override fun showUsers(users: List<GitHubUserListItem>) {
        adapter.setUsers(users)
    }

    override fun showError(message: String) {
        Toast.makeText(context, "Error: $message", Toast.LENGTH_SHORT).show()
    }

    override fun onUserClick(user: GitHubUserListItem) {
        presenter.showUserFragment(user.login)
    }
}