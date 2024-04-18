package com.example.cleanarchitecture.di

import android.content.Context
import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.UserStorage
import com.example.cleanarchitecture.data.storage.sharedPrefs.SharedPrefUserStorageImpl
import com.example.cleanarchitecture.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModuleDi {

    @Singleton
    @Provides
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage {
        return SharedPrefUserStorageImpl(context)
    }

    @Singleton
    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage)
    }

}