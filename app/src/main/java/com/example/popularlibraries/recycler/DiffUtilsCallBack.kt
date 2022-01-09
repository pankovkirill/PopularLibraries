package com.example.popularlibraries.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.popularlibraries.data.GitHubUserListItem

class DiffUtilsCallBack(
    private val oldUsersList: List<GitHubUserListItem>,
    private val newUsersList: List<GitHubUserListItem>,
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldUsersList.size

    override fun getNewListSize() = newUsersList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldUsersList[oldItemPosition].id == newUsersList[newItemPosition].id


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val (_, oldLogin, oldUrl) = oldUsersList[oldItemPosition]
        val (_, newLogin, newUrl) = newUsersList[newItemPosition]

        return oldLogin == newLogin && oldUrl == newUrl
    }
}