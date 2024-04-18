package com.example.cleanarchitecture.di

import android.content.Context
import com.example.cleanarchitecture.domain.usecase.GetUserUseCase
import com.example.cleanarchitecture.domain.usecase.SaveUserUseCase
import com.example.cleanarchitecture.presentation.viewmodelfactory.MainViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModuleDi(val context: Context) {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return context;
    }
    @Provides
    fun provideMainViewModelFactory(
        getUserUseCase: GetUserUseCase,
        saveUserUseCase: SaveUserUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(getUserUseCase, saveUserUseCase)
    }

}