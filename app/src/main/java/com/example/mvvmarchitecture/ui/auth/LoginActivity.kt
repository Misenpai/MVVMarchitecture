package com.example.mvvmarchitecture.ui.auth

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.data.db.entities.User
import com.example.mvvmarchitecture.databinding.ActivityLoginBinding
import com.example.mvvmarchitecture.utils.hide
import com.example.mvvmarchitecture.utils.show
import com.example.mvvmarchitecture.utils.toast

class LoginActivity : AppCompatActivity(),AuthListener {
    private lateinit var progress_bar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this
        progress_bar = binding.progressBar
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
        toast("${user.name} is logged in")
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)
    }
}