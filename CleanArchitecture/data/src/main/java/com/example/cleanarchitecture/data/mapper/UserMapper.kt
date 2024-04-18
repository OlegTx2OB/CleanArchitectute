package com.example.cleanarchitecture.data.mapper

import com.example.cleanarchitecture.data.dto.UserDto
import com.example.cleanarchitecture.domain.model.User

class UserMapper {

    fun toDto(user: User): UserDto {
        return UserDto(
            firstName = user.firstName)
    }

    fun toModel(userDto: UserDto): User {
        return User(
            firstName = userDto.firstName
        )
    }
}