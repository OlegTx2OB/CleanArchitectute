package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.domain.repository.UserRepository
import com.example.cleanarchitecture.domain.usecase.GetUserUseCase
import com.example.cleanarchitecture.domain.usecase.SaveUserUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModuleDi {

    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase {
        return GetUserUseCase(userRepository)
    }

    @Provides
    fun provideSaveUserUseCase(userRepository: UserRepository): SaveUserUseCase {
        return SaveUserUseCase(userRepository)
    }

}