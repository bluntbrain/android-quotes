package com.ishanlakhwani.mvvmquotesapp.data.repositories

import com.ishanlakhwani.mvvmquotesapp.data.network.MyApi
import com.ishanlakhwani.mvvmquotesapp.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {

    suspend fun userLogin(email: String, password: String) : Response<AuthResponse>{
        return MyApi().userLogin(email,password)
    }
}