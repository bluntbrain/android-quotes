package com.ishanlakhwani.mvvmquotesapp.ui.home.profile

import androidx.lifecycle.ViewModel
import com.ishanlakhwani.mvvmquotesapp.data.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}