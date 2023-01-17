package com.janyel97.nextree.data.api

import com.janyel97.nextree.data.model.CountryResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("countries/")
    suspend fun getCountries(): Response<CountryResponseModel>
}