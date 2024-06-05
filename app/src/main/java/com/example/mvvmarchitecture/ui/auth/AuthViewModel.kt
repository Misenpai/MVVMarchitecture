package com.example.mvvmarchitecture.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmarchitecture.data.repository.UserRepository
import com.example.mvvmarchitecture.utils.Coroutines

class AuthViewModel:ViewModel() {

    var email:String? = null
    var password:String?=null

    var authListener: AuthListener?=null

    fun onLoginButtonClicked(view: View){
        authListener?.onStarted()
        if (email.isNullOrEmpty()||password.isNullOrEmpty()){
            authListener?.onFailure("Invalid Email or Password")
            return
        }
        Coroutines.main {
            val response = UserRepository().userLogin(email!!,password!!)
            if (response.isSuccessful){
                authListener?.onSuccess(response.body()?.user!!)
            }else{
                authListener?.onFailure("Error Code: ${response.code()}")
            }
        }
    }
}