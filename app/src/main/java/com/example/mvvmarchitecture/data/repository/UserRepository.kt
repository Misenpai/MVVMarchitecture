package com.example.mvvmarchitecture.data.repository

import com.example.mvvmarchitecture.data.network.MyApi
import com.example.mvvmarchitecture.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {
    suspend fun userLogin(email:String,password:String):Response<AuthResponse>{
        return MyApi().userLogin(email,password)
    }
}