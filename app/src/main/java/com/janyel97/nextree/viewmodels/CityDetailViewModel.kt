package com.janyel97.nextree.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.janyel97.nextree.common.NetworkResult
import com.janyel97.nextree.data.model.urbanareas.CategoryDataItem
import com.janyel97.nextree.data.repository.MainRepository
import com.janyel97.nextree.di.CityId
import com.janyel97.nextree.utils.hrefToId
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityDetailViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    @CityId cityId: String
) : ViewModel(), LifecycleObserver {

    var fullName by mutableStateOf("")
    var continent by mutableStateOf("")
    var mayor by mutableStateOf("")
    var cityHrefId by mutableStateOf("")
    var image by mutableStateOf("")

    var error: String? by mutableStateOf(null)

    val detailCategoriesList = SnapshotStateList<CategoryDataItem>()


    init {
        if (cityId.isNotEmpty()) {
            getUrbanArea(cityId)
            getUrbanAreaImages(cityId)
            getUrbanAreaDetails(cityId)
        }
    }

    private fun getUrbanAreaDetails(cityId: String) = viewModelScope.launch {
        when (val result = mainRepository.getUrbanAreaDetailsById(cityId)) {
            is NetworkResult.Success -> {
                result.data?.let {
                    detailCategoriesList.clear()
                    detailCategoriesList.addAll(it.categories)
                }
            }
            else -> {
                error = "Network Error"
                Log.e("Network Error", result.message.toString())
            }
        }

    }

    private fun getUrbanAreaImages(cityId: String) = viewModelScope.launch {
        when (val result = mainRepository.getUrbanAreaImagesById(cityId)) {
            is NetworkResult.Success -> {
                result.data?.let {
                    image = it.photos[0].image.mobile
                }
            }
            else -> {
                error = "Network Error"
                Log.e("Network Error", result.message.toString())
            }
        }
    }

    private fun getUrbanArea(cityId: String) = viewModelScope.launch {
        when (val result = mainRepository.getUrbanAreaById(cityId)) {
            is NetworkResult.Success -> {
                try {
                    result.data?.let { ua ->
                        fullName = ua.full_name
                        continent = ua.continent
                        ua.mayor?.let { mayor = it }
                        cityHrefId = ua.teleport_city_url.hrefToId()
                    }
                } catch (e: Error) {
                    error = e.message
                    Log.e("Error Setting values", e.message.toString())
                }
            }
            else -> {
                error = "Network Error"
                Log.e("Network Error", result.message.toString())
            }
        }
    }
}