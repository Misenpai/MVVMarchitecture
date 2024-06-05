package com.example.mvvmarchitecture.ui.auth

import androidx.lifecycle.LiveData
import com.example.mvvmarchitecture.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message:String)
}