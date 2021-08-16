package com.onedev.dicoding.coronaindonesia.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.onedev.dicoding.coronaindonesia.api.ApiServiceBuilder
import com.onedev.dicoding.coronaindonesia.model.Province
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository() {
    val showProgress = MutableLiveData<Boolean>()
    val province = MutableLiveData<Province>()

    fun getProvince() {
        showProgress.value = true
        ApiServiceBuilder.instance.getDataProvince()
            .enqueue(object : Callback<Province> {
                override fun onResponse(call: Call<Province>, response: Response<Province>) {
                    if (response.isSuccessful) {
                        showProgress.value = false
                        province.value = response.body()
                        Log.d("onResponse", Gson().toJson(response.body()))
                    }
                }

                override fun onFailure(call: Call<Province>, t: Throwable) {
                    showProgress.value = false
                    Log.d("onFailure", t.localizedMessage!!)
                }
            })
    }
}