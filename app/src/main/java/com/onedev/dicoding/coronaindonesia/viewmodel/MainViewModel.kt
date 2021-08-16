package com.onedev.dicoding.coronaindonesia.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.onedev.dicoding.coronaindonesia.model.Province
import com.onedev.dicoding.coronaindonesia.repository.MainRepository

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val repository = MainRepository()
    val showProgress: LiveData<Boolean>
    val province: LiveData<Province>

    init {
        this.showProgress = repository.showProgress
        this.province = repository.province
    }

    fun getProvince() {
        repository.getProvince()
    }
}