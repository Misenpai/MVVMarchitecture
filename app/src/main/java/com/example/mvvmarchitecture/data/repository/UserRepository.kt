package com.example.mvvmarchitecture.data.repository

import com.example.mvvmarchitecture.data.db.entities.AppDatabase
import com.example.mvvmarchitecture.data.db.entities.User
import com.example.mvvmarchitecture.data.network.MyApi
import com.example.mvvmarchitecture.data.network.SafeApiRequest
import com.example.mvvmarchitecture.data.network.responses.AuthResponse


class UserRepository(
    private val api:MyApi,
    private val db:AppDatabase
):SafeApiRequest() {
    suspend fun userLogin(email:String,password:String):AuthResponse{
        return apiRequest { api.userLogin(email,password) }
    }

    suspend fun saveUser(user:User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getUser()
}