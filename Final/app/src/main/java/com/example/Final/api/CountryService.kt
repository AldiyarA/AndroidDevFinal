package com.example.Final.api

import com.example.Final.models.Country
import com.example.Final.models.Statistic
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryService {
    @GET("countries")
    suspend fun getCountries(): Response<List<Country>>

    @GET("country/{slug}")
    suspend fun getStatistic(@Path("slug") slug: String): Response<List<Statistic>>
}