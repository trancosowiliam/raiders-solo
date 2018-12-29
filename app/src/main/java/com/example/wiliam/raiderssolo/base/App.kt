package com.consultaremedios.base

import android.app.Application
import com.consultaremedios.base.di.appModule
import org.koin.android.ext.android.startKoin

@Suppress("unused")
class App : Application() {

    private val modules = listOf(
        appModule
    )

    override fun onCreate() {
        super.onCreate()
        startKoin(this, modules)
    }
}