package com.example.animesearcher.data.models.dtos

import com.google.gson.annotations.SerializedName

class AnimeByIdWrapper {
    @SerializedName("data")
    var data: ShortAnimeModel = ShortAnimeModel();
}