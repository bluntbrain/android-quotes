package com.ishanlakhwani.mvvmquotesapp.ui.auth

import android.app.ProgressDialog.show
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ishanlakhwani.mvvmquotesapp.R
import com.ishanlakhwani.mvvmquotesapp.data.db.AppDatabase
import com.ishanlakhwani.mvvmquotesapp.data.db.entities.User
import com.ishanlakhwani.mvvmquotesapp.data.network.MyApi
import com.ishanlakhwani.mvvmquotesapp.data.repositories.UserRepository
import com.ishanlakhwani.mvvmquotesapp.databinding.ActivityLoginBinding
import com.ishanlakhwani.mvvmquotesapp.ui.home.HomeActivity
import com.ishanlakhwani.mvvmquotesapp.util.hide
import com.ishanlakhwani.mvvmquotesapp.util.show
import com.ishanlakhwani.mvvmquotesapp.util.snackbar
import com.ishanlakhwani.mvvmquotesapp.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val api = MyApi()
        val db = AppDatabase(this)
        val repository = UserRepository(api, db)
        val factory = AuthViewModelFactory(repository)

        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this, factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this

        viewModel.getLoggedInUser().observe(this, Observer { user ->
            if(user != null){
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })

    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
    }
}