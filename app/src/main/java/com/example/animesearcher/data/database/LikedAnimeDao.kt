package com.example.animesearcher.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.animesearcher.data.models.db.LikedAnime
import kotlinx.coroutines.Deferred

@Dao
interface LikedAnimeDao {
    @Query("SELECT * FROM likedanime")
    suspend fun getAll(): List<LikedAnime>

    @Query("SELECT * FROM LikedAnime WHERE animeId = :animeId")
    suspend fun getByAnimeId(animeId: Int): List<LikedAnime>;

    @Query("SELECT * FROM likedanime WHERE uid IN (:animeIds)")
    fun loadAllByIds(animeIds: IntArray): List<LikedAnime>

    @Insert
    suspend fun insertAll(vararg animes: LikedAnime)

    @Delete
    suspend fun delete(user: LikedAnime)

    @Query("DELETE FROM LikedAnime WHERE animeId = :animeId")
    suspend fun deleteByAnimeId(animeId: Int);
}