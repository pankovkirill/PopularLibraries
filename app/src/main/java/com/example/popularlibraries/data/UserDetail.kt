package com.example.popularlibraries.data

data class UserDetail(
    val id: Int,
    val login: String,
    val url: String,
    val type: String,
    val sysAdmin: Boolean,
)