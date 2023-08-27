package com.jama.data.network


import com.jama.domain.models.UserData
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsers() :Flow<List<UserData>>
}