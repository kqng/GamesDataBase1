package com.example.gamesdatabase

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
    private fun initKoin() {
        val modules = listOf(domainModule,networkModule,repositoryModule,presentationModule)
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(modules)
        }
    }
}