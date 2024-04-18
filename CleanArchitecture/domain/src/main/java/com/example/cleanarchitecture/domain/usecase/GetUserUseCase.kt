package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.model.User
import com.example.cleanarchitecture.domain.repository.UserRepository

class GetUserUseCase(private val userRepository: UserRepository) {

    fun execute(): User {
        return userRepository.getUser()
    }
}