package com.ishanlakhwani.mvvmquotesapp.data.repositories

import com.ishanlakhwani.mvvmquotesapp.data.db.AppDatabase
import com.ishanlakhwani.mvvmquotesapp.data.db.entities.User
import com.ishanlakhwani.mvvmquotesapp.data.network.MyApi
import com.ishanlakhwani.mvvmquotesapp.data.network.SafeApiRequest
import com.ishanlakhwani.mvvmquotesapp.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository(
    private val api: MyApi,
    private val db : AppDatabase
): SafeApiRequest() {

    suspend fun userLogin(email: String, password: String) : AuthResponse{
        return apiRequest {api.userLogin(email,password)}
        }

    suspend fun userSignup(
        name: String,
        email: String,
        password: String) : AuthResponse{
        return apiRequest {api.userSignup(name,email,password)}
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    override fun getUser() = db.getUserDao().getuser()


}
