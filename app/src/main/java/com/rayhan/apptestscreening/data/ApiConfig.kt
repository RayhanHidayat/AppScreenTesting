package com.rayhan.apptestscreening.data

import android.content.Context
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object {
        private const val BASE_URL = "http://www.mocky.io/v2/"

        fun getApiService(context: Context): ApiService {
            val gson = GsonBuilder().setDateFormat("dd-MM-yyyy").create()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}