package com.jama.data.repository

import com.jama.data.network.ApiService
import com.jama.domain.models.UserData
import com.jama.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private var apiService: ApiService) :UserRepository {
    override fun getUsers(): Flow<List<UserData>> {
        return apiService.getUsers()
    }
}