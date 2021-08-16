package com.onedev.dicoding.coronaindonesia.api

import com.onedev.dicoding.coronaindonesia.model.Province
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("indonesia/provinsi")
    fun getDataProvince(): Call<Province>
}