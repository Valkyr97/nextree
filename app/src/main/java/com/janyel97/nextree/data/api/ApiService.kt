package com.janyel97.nextree.data.api

import com.janyel97.nextree.data.model.*
import com.janyel97.nextree.data.model.city.CitiesResponseModel
import com.janyel97.nextree.data.model.city.CityDetailResponse
import com.janyel97.nextree.data.model.common.LinksModel
import com.janyel97.nextree.data.model.country.CountryItemsModel
import com.janyel97.nextree.data.model.urbanareas.UrbanAreaDetailsResponseModel
import com.janyel97.nextree.data.model.urbanareas.UrbanAreasByIdResponse
import com.janyel97.nextree.data.model.urbanareas.UrbanAreasImagesResponseModel
import com.janyel97.nextree.data.model.urbanareas.UrbanAreasResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("countries/")
    suspend fun getCountries(): Response<LinksModel<CountryItemsModel>>

    @GET("cities/")
    suspend fun findCitiesByName(@Query("search") search: String?): Response<CitiesResponseModel>

    @GET("cities/{cityId}/")
    suspend fun getCityDetails(@Path("cityId") cityId: String): Response<CityDetailResponse>

    @GET("urban_areas/")
    suspend fun getUrbanAreas(): Response<LinksModel<UrbanAreasResponseModel>>

    @GET("urban_areas/{uaId}/")
    suspend fun getUrbanById(@Path("uaId") uaId: String): Response<UrbanAreasByIdResponse>

    @GET("urban_areas/{uaId}/images/")
    suspend fun getUrbanAreaImagesById(@Path("uaId") uaId: String):
            Response<UrbanAreasImagesResponseModel>

    @GET("urban_areas/{uaId}/details/")
    suspend fun getUrbanAreaDetailsById(@Path("uaId") uaId: String):
            Response<UrbanAreaDetailsResponseModel>

}