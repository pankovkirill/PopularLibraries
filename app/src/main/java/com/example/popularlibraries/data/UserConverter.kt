package com.example.popularlibraries.data

class UserConverter() {

    fun convertUserListToUserItemList(
        userLists: List<User>,
    ): List<UserListItem> {
        val userItemList = ArrayList<UserListItem>()
        for (user in userLists) {
            userItemList.add(convertUserToUserItem(user))
        }
        return userItemList
    }

    fun convertUserToUserDetail(
        user: User,
    ) = UserDetail(
        user.id,
        user.login,
        user.avatarUrl,
        user.type,
        user.siteAdmin
    )

    private fun convertUserToUserItem(
        user: User,
    ) = UserListItem(
        user.id,
        user.login,
        user.avatarUrl
    )
}