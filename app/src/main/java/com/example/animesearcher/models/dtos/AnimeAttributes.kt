package com.example.animesearcher.models.dtos

import com.google.gson.annotations.SerializedName

class AnimeAttributes {
    @SerializedName("titles")
    var titles: AnimeTitles = AnimeTitles();
    @SerializedName("posterImage")
    var posterImage = PosterImagesNames();
    @SerializedName("averageRating")
    var averageRating: String? = "";

    @SerializedName("startDate")
    var startDate = "";
    @SerializedName("endDate")
    var endDate = "";
    @SerializedName("description")
    var description = "";

}