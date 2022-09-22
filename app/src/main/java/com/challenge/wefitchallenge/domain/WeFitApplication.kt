package com.challenge.wefitchallenge.domain

import android.app.Application
import com.challenge.wefitchallenge.viewModelModule
import org.koin.core.context.startKoin

class WeFitApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(viewModelModule)
        }
    }

}