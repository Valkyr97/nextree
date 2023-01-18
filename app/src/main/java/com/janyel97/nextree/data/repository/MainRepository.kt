package com.janyel97.nextree.data.repository

import com.janyel97.nextree.common.BaseApiResponse
import com.janyel97.nextree.common.NetworkResult
import com.janyel97.nextree.data.api.ApiService
import com.janyel97.nextree.data.model.*
import com.janyel97.nextree.data.model.city.CitiesResponseModel
import com.janyel97.nextree.data.model.city.CityDetailResponse
import com.janyel97.nextree.data.model.common.LinksModel
import com.janyel97.nextree.data.model.country.CountryItemsModel
import com.janyel97.nextree.data.model.urbanareas.UrbanAreasByIdResponse
import com.janyel97.nextree.data.model.urbanareas.UrbanAreasImagesResponseModel
import com.janyel97.nextree.data.model.urbanareas.UrbanAreasResponseModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : BaseApiResponse() {

    suspend fun getCountries(): NetworkResult<LinksModel<CountryItemsModel>> =
        withContext(ioDispatcher) {
            safeApiCall { apiService.getCountries() }
        }

    suspend fun getUrbanAreas(): NetworkResult<LinksModel<UrbanAreasResponseModel>> =
        withContext(ioDispatcher) {
            safeApiCall { apiService.getUrbanAreas() }
        }

    suspend fun getUrbanAreaById(uaId: String): NetworkResult<UrbanAreasByIdResponse> =
        withContext(ioDispatcher) {
            safeApiCall { apiService.getUrbanById(uaId) }
        }

    suspend fun getUrbanAreaImagesById(uaId: String): NetworkResult<UrbanAreasImagesResponseModel> =
        withContext(ioDispatcher) {
            safeApiCall { apiService.getUrbanAreaImagesById(uaId) }
        }

    suspend fun findCitiesByName(search: String?): NetworkResult<CitiesResponseModel> =
        withContext(ioDispatcher) {
            safeApiCall { apiService.findCitiesByName(search) }
        }

    suspend fun getCityById(cityId: String): NetworkResult<CityDetailResponse> =
        withContext(ioDispatcher) {
            safeApiCall { apiService.getCityDetails(cityId) }
        }
}