package com.ishanlakhwani.mvvmquotesapp.data.network.responses

import com.ishanlakhwani.mvvmquotesapp.data.db.entities.User

data class AuthResponse(
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User?
)