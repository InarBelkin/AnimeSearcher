package com.example.animesearcher.data.database

import androidx.lifecycle.LiveData
import com.example.animesearcher.data.models.dtos.ShortAnimeModel

interface IDbRepos {
    val likedAnimals: LiveData<List<ShortAnimeModel>>
    suspend fun getAll(): List<ShortAnimeModel>
    suspend fun AddLike(anime: ShortAnimeModel)
}