package com.example.cleanarchitecture.app

import android.app.Application
import com.example.cleanarchitecture.di.AppComponent
import com.example.cleanarchitecture.di.AppModuleDi
import com.example.cleanarchitecture.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModuleDi(AppModuleDi(this)).build()
    }
}