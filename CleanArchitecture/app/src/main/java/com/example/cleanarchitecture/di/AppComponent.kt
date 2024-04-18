package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.presentation.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModuleDi::class, DomainModuleDi::class, DataModuleDi::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}