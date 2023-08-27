package com.jama.domain.repository

import com.jama.domain.models.UserData
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers():Flow<List<UserData>>
}