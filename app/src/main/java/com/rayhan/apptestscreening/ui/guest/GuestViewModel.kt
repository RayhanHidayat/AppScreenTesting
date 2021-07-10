package com.rayhan.apptestscreening.ui.guest

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rayhan.apptestscreening.data.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GuestViewModel(application: Application) : AndroidViewModel(application) {

    private val tag = "GuideViewModel"
    private val client = ApiConfig.getApiService(application)

    private val _guestData = MutableLiveData<List<GuideModel>>()

    val guestData: LiveData<List<GuideModel>> = _guestData

    fun getGuideData() {
        client.getAllData().enqueue(object : Callback<List<GuideModel>> {
            override fun onResponse(
                call: Call<List<GuideModel>>,
                response: Response<List<GuideModel>>
            ) {
                Log.i(tag, "onResponse $response")
                if (response.isSuccessful) {

                    _guestData.value = response.body()

                    if (_guestData.value == null) {
                        Log.w(tag, "Did not receive valid response")
                        return
                    }

                    val data = ImageUrlList.generateAllImage()
                    for (i in data.indices) {
                        _guestData.value!![i].image = data[i]
                    }

                } else {
                    Log.w(tag, "invalid response in onResponse")
                }
            }

            override fun onFailure(call: Call<List<GuideModel>>, t: Throwable) {
                Log.e(tag, "onFailure $t")
            }

        })
    }
}