package com.rosutovein.android4aproject.injection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EsieaApplication : Application() {
    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin {
            androidContext(this@EsieaApplication)
            // modules
            modules(presentationModule)
        }
    }
}