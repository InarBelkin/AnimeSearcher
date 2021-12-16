package com.example.animesearcher.data.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.animesearcher.data.models.dtos.ShortAnimeModel
import javax.inject.Inject

class DbRepos @Inject constructor(private val dao: LikedAnimeDao) {
    private val _likedAnimals =
        MutableLiveData<List<ShortAnimeModel>>(ArrayList());
    val likedAnimals: LiveData<List<ShortAnimeModel>>
        get() = _likedAnimals;

    suspend fun getAll(): List<ShortAnimeModel> {
        val animals = dao.getAll();
        val shortAnimals = animals.map {
            val anim = ShortAnimeModel();
            anim.id = it.animeId;
            anim.attributes.titles.English = it.animeTitle!!;
            anim;
        }
        _likedAnimals.value = shortAnimals;
        return shortAnimals;
    }
}