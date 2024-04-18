package com.example.cleanarchitecture.domain.repository

import com.example.cleanarchitecture.domain.model.User

interface UserRepository {
    fun saveUser(user: User): Boolean

    fun getUser(): User
}