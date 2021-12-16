package com.example.animesearcher.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.animesearcher.data.models.db.LikedAnime

@Dao
interface LikedAnimeDao {
    @Query("SELECT * FROM likedanime")
    fun getAll(): LiveData<List<LikedAnime>>

    @Query("SELECT * FROM likedanime WHERE uid IN (:animeIds)")
    fun loadAllByIds(animeIds: IntArray): List<LikedAnime>

    @Insert
    suspend fun insertAll(vararg animes: LikedAnime)

    @Delete
    fun delete(user: LikedAnime)
}