package com.ishanlakhwani.mvvmquotesapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.ishanlakhwani.mvvmquotesapp.data.repositories.UserRepository
import com.ishanlakhwani.mvvmquotesapp.util.ApiException
import com.ishanlakhwani.mvvmquotesapp.util.Coroutines

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClick(view : View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            //show error message
            authListener?.onFailure("Invalid email or password")
            return
        }
        Coroutines.main {
            try {
                val authResponse = UserRepository().userLogin(email!!, password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)

            }catch (e : ApiException){
                authListener?.onFailure(e.message!!)
            }


        }
}}