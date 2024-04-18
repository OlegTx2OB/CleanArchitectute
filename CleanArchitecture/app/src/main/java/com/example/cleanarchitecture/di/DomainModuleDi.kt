package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.domain.usecase.GetUserUseCase
import com.example.cleanarchitecture.domain.usecase.SaveUserUseCase
import org.koin.dsl.module

val domainModuleDi = module {

    factory<GetUserUseCase> {
        GetUserUseCase(userRepository = get())
    }

    factory<SaveUserUseCase> {
        SaveUserUseCase(userRepository = get())
    }

}