package com.example.animesearcher.data.models.dtos

import com.google.gson.annotations.SerializedName

class ShortAnimeModel {

    @SerializedName("type")
    var myType:String = "";
    @SerializedName("attributes")
    var attributes: AnimeAttributes = AnimeAttributes()
    @SerializedName("id")
    var id:Int = 0;

    var isLiked = false;


}