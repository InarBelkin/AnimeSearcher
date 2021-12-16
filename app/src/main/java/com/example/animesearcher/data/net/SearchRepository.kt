package com.example.animesearcher.data.net

import android.util.Log
import com.example.animesearcher.data.net.connection.NetworkService
import com.example.animesearcher.data.models.dtos.AnimeListDto
import com.example.animesearcher.data.models.dtos.ShortAnimeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class SearchRepository @Inject constructor() : ISearchRepository {
    private val TAG = "SearchRepository";

    override fun getAllAnime(myCall: (ArrayList<ShortAnimeModel>) -> Unit) {
        NetworkService.Instance.anime.getAllAnime()
            .enqueue(object : Callback<AnimeListDto> {
                override fun onResponse(
                    call: Call<AnimeListDto>,
                    response: Response<AnimeListDto>
                ) {
                    if (response.isSuccessful) {
                        myCall.invoke(response.body()!!.data);
                    } else {
                        Log.e(TAG, response.message());
                    }
                }
                override fun onFailure(call: Call<AnimeListDto>, t: Throwable) {
                    Log.e(TAG, t.localizedMessage!!);
                }
            }

            )

    }

    override fun getAnimeByName(searchString:String, myCall: (ArrayList<ShortAnimeModel>) -> Unit){
        NetworkService.Instance.anime.getAnimeByName(searchString)
            .enqueue(object : Callback<AnimeListDto>{
                override fun onResponse(
                    call: Call<AnimeListDto>,
                    response: Response<AnimeListDto>
                ) {
                    if (response.isSuccessful) {
                        myCall.invoke(response.body()!!.data);
                    } else {
                        Log.e(TAG, response.message());
                    }
                }

                override fun onFailure(call: Call<AnimeListDto>, t: Throwable) {
                    Log.e(TAG, t.localizedMessage!!);
                }

            })

    }


}