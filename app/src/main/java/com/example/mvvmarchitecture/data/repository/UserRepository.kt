package com.example.mvvmarchitecture.data.repository

import com.example.mvvmarchitecture.data.network.MyApi
import com.example.mvvmarchitecture.data.network.SafeApiRequest
import com.example.mvvmarchitecture.data.network.responses.AuthResponse


class UserRepository:SafeApiRequest() {
    suspend fun userLogin(email:String,password:String):AuthResponse{
        return apiRequest { MyApi().userLogin(email,password) }
    }
}