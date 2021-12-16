package com.example.animesearcher.data.net.connection

import com.example.animesearcher.data.models.dtos.AnimeListDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApi {
    @GET("anime")
    fun getAllAnime(): Call<AnimeListDto>
    @GET( "anime")
    fun getAnimeByName(@Query("filter[text]") text: String):Call<AnimeListDto>
}