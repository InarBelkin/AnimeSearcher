package com.example.animesearcher.data.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.animesearcher.data.models.db.LikedAnime
import com.example.animesearcher.data.models.dtos.ShortAnimeModel
import javax.inject.Inject

class DbRepos @Inject constructor(private val dao: LikedAnimeDao) : IDbRepos {
    private val _likedAnimals =
        MutableLiveData<List<ShortAnimeModel>>(ArrayList());
    override val likedAnimals: LiveData<List<ShortAnimeModel>>
        get() = _likedAnimals;

    override suspend fun getAll(): List<ShortAnimeModel> {
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

    override suspend fun AddLike(anime: ShortAnimeModel) {
        val likedAnima = LikedAnime(0, anime.id, anime.attributes.titles.English);
        dao.insertAll(likedAnima);
    }

    override suspend fun deleteByAnimeId(animeId: Int) {
        dao.deleteByAnimeId(animeId);
    }

    override suspend fun getByAnimeId(animeId: Int): List<LikedAnime> {
        return dao.getByAnimeId(animeId);
    }

}