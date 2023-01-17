package com.janyel97.nextree.data.repository

import com.janyel97.nextree.common.BaseApiResponse
import com.janyel97.nextree.common.NetworkResult
import com.janyel97.nextree.data.api.ApiService
import com.janyel97.nextree.data.model.CountryResponseModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : BaseApiResponse() {

    suspend fun getCountries(): NetworkResult<CountryResponseModel> =
        withContext(ioDispatcher) {
            safeApiCall { apiService.getCountries() }
        }

}