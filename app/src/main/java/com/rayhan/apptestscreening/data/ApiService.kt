package com.rayhan.apptestscreening.data

import com.rayhan.apptestscreening.ui.guest.GuideModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("596dec7f0f000023032b8017")
    fun getAllData(): Call<List<GuideModel>>
}