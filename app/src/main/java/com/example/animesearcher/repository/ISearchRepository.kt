package com.example.animesearcher.repository

import com.example.animesearcher.models.dtos.ShortAnimeModel

interface ISearchRepository {
    fun getAllAnime(myCall: (ArrayList<ShortAnimeModel>) -> Unit)
    fun getAnimeByName(searchString: String, myCall: (ArrayList<ShortAnimeModel>) -> Unit)
}