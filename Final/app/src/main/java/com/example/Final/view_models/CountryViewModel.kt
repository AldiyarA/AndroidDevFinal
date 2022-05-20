package com.example.Final.view_models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Final.models.Country
import com.example.Final.models.Statistic
import com.example.Final.repository.CountryRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class CountryViewModel(private val repository: CountryRepository): ViewModel()  {
    val countries: MutableLiveData<Response<List<Country>>> = MutableLiveData()
    val statistics: MutableLiveData<Response<List<Statistic>>> = MutableLiveData()

    fun getCountries(){
        viewModelScope.launch {
            val response = repository.getCountries()
            Log.e("BODY", response.body().toString())
            countries.value = response
        }
    }

    fun getStatistics(slug: String){
        viewModelScope.launch {
            val response = repository.getStatistics(slug)
            Log.e("BODY", response.body().toString())
            statistics.value = response
        }
    }
}