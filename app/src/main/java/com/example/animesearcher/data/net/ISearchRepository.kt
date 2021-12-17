package com.example.animesearcher.data.net

import com.example.animesearcher.data.models.dtos.ShortAnimeModel

interface ISearchRepository {
    fun getAllAnime(myCall: (ArrayList<ShortAnimeModel>) -> Unit)
    fun getAnimeByName(searchString: String, myCall: (ArrayList<ShortAnimeModel>) -> Unit)
    fun getAnimeById(animeId: Int, myCall: (ShortAnimeModel) -> Unit)
}