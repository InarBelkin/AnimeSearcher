package com.example.animesearcher.other

import android.app.Application


import androidx.room.Room
import com.example.animesearcher.database.AppDatabase
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp()
class AnimeSearcherApp : Application() {
    companion object {
        lateinit var instance: AnimeSearcherApp
            private set
    }

    //private var _database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
    }

    lateinit var database: AppDatabase
        private set
}