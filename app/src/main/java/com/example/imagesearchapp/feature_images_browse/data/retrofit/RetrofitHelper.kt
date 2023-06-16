package com.example.imagesearchapp.feature_images_browse.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getInstance(): Retrofit {
        val baseUrl = "https://pixabay.com/api/"
        val personalKey = "37377299-732b54e9475b9577a01729dc5"
        val baseApiUrl="https://pixabay.com/api/"
        val apiKeyUrl = "${baseApiUrl}?key=${personalKey}"

        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }
}