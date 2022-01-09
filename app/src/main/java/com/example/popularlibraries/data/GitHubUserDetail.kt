package com.example.popularlibraries.data

data class GitHubUserDetail(
    val id: Int,
    val login: String,
    val url: String,
    val type: String,
    val sysAdmin: Boolean,
)