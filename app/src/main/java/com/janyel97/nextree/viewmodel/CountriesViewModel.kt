package com.janyel97.nextree.viewmodel

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.janyel97.nextree.common.NetworkResult
import com.janyel97.nextree.data.model.PlaceModel
import com.janyel97.nextree.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel(), LifecycleObserver {
    init {
        getCountries()
    }

    val countriesList = SnapshotStateList<PlaceModel>()

    private fun getCountries() = viewModelScope.launch {
        when (val result = mainRepository.getCountries()) {
            is NetworkResult.Success -> {
                result.data?.let { countriesList.addAll(it) }
            }

            else -> {}
        }
    }
}