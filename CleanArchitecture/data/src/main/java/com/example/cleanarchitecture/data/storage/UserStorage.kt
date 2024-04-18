package com.example.cleanarchitecture.data.storage

import com.example.cleanarchitecture.data.dto.UserDto

interface UserStorage {

    fun save(userDto: UserDto): Boolean

    fun get(): UserDto
}