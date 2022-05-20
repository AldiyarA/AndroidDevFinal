package com.example.Final.app

import android.app.Application
import com.example.Final.di.networkModule
import com.example.Final.di.repositoryModule
import com.example.Final.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate(){
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(viewModelModule, repositoryModule, networkModule))
        }
    }
}