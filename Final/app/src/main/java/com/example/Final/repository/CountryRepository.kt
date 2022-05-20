package com.example.Final.repository

import com.example.Final.api.CountryService
import com.example.Final.models.Country
import com.example.Final.models.Statistic
import retrofit2.Response

class CountryRepository(private val service: CountryService) {
    suspend fun getCountries(): Response<List<Country>>{
        return service.getCountries()
    }

    suspend fun getStatistics(slug: String): Response<List<Statistic>>{
        return service.getStatistic(slug)
    }
}