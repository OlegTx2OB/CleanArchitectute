package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModuleDi = module {

    viewModel<MainViewModel>{
        MainViewModel(
            getUserUseCase = get(),
            saveUserUseCase = get()
        )
    }
}