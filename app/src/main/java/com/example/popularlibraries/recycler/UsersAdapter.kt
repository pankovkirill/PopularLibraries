package com.example.popularlibraries.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.popularlibraries.data.UserListItem
import com.example.popularlibraries.databinding.UserListItemBinding

class UsersAdapter(private val userClickListener: OnItemClickListener) :
    RecyclerView.Adapter<UserViewHolder>() {

    private var users = ArrayList<UserListItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position], userClickListener)
    }

    override fun getItemCount() = users.size

    fun setUsers(newUsers: List<UserListItem>) {
        val diffUtilsCallBack = DiffUtilsCallBack(users, newUsers)
        val diffResult = DiffUtil.calculateDiff(diffUtilsCallBack)
        users.clear()
        users.addAll(newUsers)
        diffResult.dispatchUpdatesTo(this)
    }

    interface OnItemClickListener {
        fun onUserClick(user: UserListItem)
    }
}