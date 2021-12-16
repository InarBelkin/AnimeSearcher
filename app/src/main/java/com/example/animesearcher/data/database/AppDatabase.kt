package com.example.animesearcher.data.database

import androidx.room.*
import com.example.animesearcher.data.models.db.LikedAnime

@Database(entities = [LikedAnime::class], version = 2)
abstract class AppDatabase() : RoomDatabase() {
    abstract fun likedAnimeDao(): LikedAnimeDao;
}