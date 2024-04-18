package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.data.mapper.UserMapper
import com.example.cleanarchitecture.data.storage.UserStorage
import com.example.cleanarchitecture.domain.model.User
import com.example.cleanarchitecture.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    private val userMapper = UserMapper()
    override fun saveUser(user: User): Boolean {
        return userStorage.save(
            userMapper.toDto(user)
        )
    }

    override fun getUser(): User {
        val userDto = userStorage.get()
        return userMapper.toModel(userDto)
    }
}