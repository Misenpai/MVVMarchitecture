package com.example.mvvmarchitecture.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmarchitecture.data.repository.UserRepository
import com.example.mvvmarchitecture.utils.Coroutines
import com.example.mvvmarchitecture.utils.Exceptions

class AuthViewModel(
    private val repository: UserRepository
):ViewModel() {

    var email:String? = null
    var password:String?=null

    var authListener: AuthListener?=null

    fun getLoggedInUser() = repository.getUser()

    fun onLoginButtonClicked(view: View){
        authListener?.onStarted()
        if (email.isNullOrEmpty()||password.isNullOrEmpty()){
            authListener?.onFailure("Invalid Email or Password")
            return
        }
        Coroutines.main {
            try{
                val authResponse = repository.userLogin(email!!,password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }

                authListener?.onFailure(authResponse.message!!)
            }catch (e:Exceptions.ApiException){
                authListener?.onFailure(e.message!!)
            }

        }
    }
}