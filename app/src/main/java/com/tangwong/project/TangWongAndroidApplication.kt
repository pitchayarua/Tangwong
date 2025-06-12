package com.tangwong.project

import android.app.Application
import com.tangwong.project.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TangWongAndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@TangWongAndroidApplication)
            modules(appModule())
        }
    }
}