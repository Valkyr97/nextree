package com.janyel97.nextree.data.api

import com.janyel97.nextree.data.model.CitiesResponseModel
import com.janyel97.nextree.data.model.CountriesResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("countries/")
    suspend fun getCountries(): Response<CountriesResponseModel>

    @GET("cities/")
    suspend fun findCitiesByName(@Query("search") search: String?): Response<CitiesResponseModel>

    @GET("cities/{cityId}/")
    suspend fun getCityDetails(@Path("cityId") cityId: String): Response<String>
}