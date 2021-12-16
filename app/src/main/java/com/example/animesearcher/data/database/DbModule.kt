package com.example.animesearcher.data.database

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
public final class DbModule {
    companion object{
        fun getDao(app:Application): LikedAnimeDao{
            return Room.databaseBuilder(app.applicationContext, AppDatabase::class.java, "database")
                .fallbackToDestructiveMigration()
                .build().likedAnimeDao();
        }

    }
}