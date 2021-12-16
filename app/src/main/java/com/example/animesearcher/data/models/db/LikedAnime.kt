package com.example.animesearcher.data.models.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LikedAnime(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "animeId") val animeId: Int,
    @ColumnInfo(name = "animeTitle") val animeTitle: String?
)
