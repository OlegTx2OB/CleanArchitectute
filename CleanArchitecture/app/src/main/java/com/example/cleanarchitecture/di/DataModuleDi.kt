package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.UserStorage
import com.example.cleanarchitecture.data.storage.sharedPrefs.SharedPrefUserStorageImpl
import com.example.cleanarchitecture.domain.repository.UserRepository
import org.koin.dsl.module

val dataModuleDi = module {

    single<UserStorage> {
        SharedPrefUserStorageImpl(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}