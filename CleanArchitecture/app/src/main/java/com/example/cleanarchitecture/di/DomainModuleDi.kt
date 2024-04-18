package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.domain.repository.UserRepository
import com.example.cleanarchitecture.domain.usecase.GetUserUseCase
import com.example.cleanarchitecture.domain.usecase.SaveUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
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