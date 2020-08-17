package com.ishanlakhwani.mvvmquotesapp.data.repositories

import com.ishanlakhwani.mvvmquotesapp.data.network.MyApi
import com.ishanlakhwani.mvvmquotesapp.data.network.SafeApiRequest
import com.ishanlakhwani.mvvmquotesapp.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository: SafeApiRequest() {

    suspend fun userLogin(email: String, password: String) : AuthResponse{
        return apiRequest {MyApi().userLogin(email,password)}
        }
    }
