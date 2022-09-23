package com.challenge.wefitchallenge.domain

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.challenge.wefitchallenge.data.models.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeFitApplication : Application() {

    lateinit var localDatabase : RoomDatabase

    override fun onCreate() {
        super.onCreate()
        initializeRoomDatabase()
        startKoin {
            androidContext(applicationContext)
            modules(viewModelModule)
            modules(persistenceModule)
        }
    }

    private fun initializeRoomDatabase() {
        localDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
    }
}