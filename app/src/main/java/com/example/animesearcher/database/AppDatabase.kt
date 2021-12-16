package com.example.animesearcher.database

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.animesearcher.models.db.LikedAnime
import dagger.hilt.android.qualifiers.ApplicationContext

@Database(entities = [LikedAnime::class], version = 2)
abstract class AppDatabase() :RoomDatabase() {
abstract fun likedAnimeDao():LikedAnimeDao;
}