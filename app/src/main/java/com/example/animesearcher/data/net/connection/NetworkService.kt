package com.example.animesearcher.data.net.connection

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {
    companion object{
        private var instance: NetworkService? = null;
        public const val Base_URL = "https://kitsu.io/api/edge/"
        private var mRetrofit: Retrofit? = null;
        val Instance:NetworkService
        get(){
            if(instance==null) instance = NetworkService()
            return instance!!;
        }

    }

    init {
        val okHttpClient = OkHttpClient().newBuilder();

        mRetrofit = Retrofit.Builder().baseUrl(Base_URL).client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create()).build();
    }

    val anime:AnimeApi = mRetrofit!!.create(AnimeApi::class.java);


}