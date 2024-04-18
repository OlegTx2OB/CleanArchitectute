package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.model.User
import com.example.cleanarchitecture.domain.repository.UserRepository

class SaveUserUseCase(private val userRepository: UserRepository) {

    fun execute(user: User): Boolean {
        return userRepository.saveUser(user)
    }

}