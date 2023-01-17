package com.janyel97.nextree.viewmodels

import android.util.Log
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.janyel97.nextree.common.NetworkResult
import com.janyel97.nextree.data.model.CountryItemModel
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

    val countriesList = SnapshotStateList<CountryItemModel>()

    private fun getCountries() = viewModelScope.launch {
        when (val result = mainRepository.getCountries()) {
            is NetworkResult.Success -> {
                result.data?.let { countriesList.addAll(it.links.countryItems) }
                Log.d("", result.toString())
            }

            else -> {
                Log.d("Network Error", result.message.toString())

            }
        }
    }
}