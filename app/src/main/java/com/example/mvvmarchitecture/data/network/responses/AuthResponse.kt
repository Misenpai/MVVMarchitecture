package com.example.mvvmarchitecture.data.network.responses

import com.example.mvvmarchitecture.data.db.entities.User

data class AuthResponse (
    val isSuccesful:Boolean?,
    val message:String?,
    val user: User?
)