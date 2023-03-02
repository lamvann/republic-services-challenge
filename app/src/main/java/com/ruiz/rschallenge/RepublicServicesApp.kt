package com.ruiz.rschallenge

import android.app.Application
import com.ruiz.drivers_and_routes.di.rsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RepublicServicesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RepublicServicesApp)
            modules(rsModule)
        }
    }
}