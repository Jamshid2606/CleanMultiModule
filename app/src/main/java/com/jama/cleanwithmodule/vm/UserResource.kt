package com.jama.cleanwithmodule.vm

import com.jama.domain.models.UserData

sealed class UserResource{
    object Loading:UserResource()
    data class Success(val list: List<UserData>?):UserResource()
    data class Error(val e: String?):UserResource()
}