package com.janyel97.nextree.viewmodels

import android.util.Log
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.janyel97.nextree.common.NetworkResult
import com.janyel97.nextree.data.model.CityItemModel
import com.janyel97.nextree.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel(), LifecycleObserver {

    init {
        getCities()
    }

    val citiesList = SnapshotStateList<CityItemModel>()

    private fun getCities(search: String? = null) = viewModelScope.launch {
        when (val result = mainRepository.findCitiesByName(search)) {
            is NetworkResult.Success -> {
                result.data?.let {
                    citiesList.clear()
                    citiesList.addAll(it.data.cities)
                }
            }
            else -> {
                Log.e("Network Error", result.message.toString())
            }
        }
    }
}