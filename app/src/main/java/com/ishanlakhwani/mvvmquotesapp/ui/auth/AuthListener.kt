package com.ishanlakhwani.mvvmquotesapp.ui.auth

import androidx.lifecycle.LiveData
import com.ishanlakhwani.mvvmquotesapp.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}