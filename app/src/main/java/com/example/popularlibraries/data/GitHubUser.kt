package com.example.popularlibraries.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitHubUser(
    @SerializedName("id")
    val id: Int = -1,
    @SerializedName("login")
    val login: String = "undefined",
    @SerializedName("avatar_url")
    val avatarUrl: String = "",
    @SerializedName("type")
    val type: String = "",
    @SerializedName("site_admin")
    val siteAdmin: Boolean = false,
) : Parcelable