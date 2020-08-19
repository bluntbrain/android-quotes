package com.ishanlakhwani.mvvmquotesapp.ui.home.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ishanlakhwani.mvvmquotesapp.data.repositories.UserRepository

class ProfileViewModelFactory(
    private val repository: UserRepository
):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(repository) as T
    }

}