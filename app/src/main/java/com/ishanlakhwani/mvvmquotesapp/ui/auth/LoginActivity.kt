package com.ishanlakhwani.mvvmquotesapp.ui.auth

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ishanlakhwani.mvvmquotesapp.R
import com.ishanlakhwani.mvvmquotesapp.data.db.entities.User
import com.ishanlakhwani.mvvmquotesapp.databinding.ActivityLoginBinding
import com.ishanlakhwani.mvvmquotesapp.util.hide
import com.ishanlakhwani.mvvmquotesapp.util.show
import com.ishanlakhwani.mvvmquotesapp.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
        toast("${user.name} is Logged in ")
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)
    }
}