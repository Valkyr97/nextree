package com.janyel97.nextree.viewmodels

import android.util.Log
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.janyel97.nextree.common.NetworkResult
import com.janyel97.nextree.data.model.common.ItemModel
import com.janyel97.nextree.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel(), LifecycleObserver {

    init {
        getUrbanAreas()
    }

    val citiesList = SnapshotStateList<ItemModel>()

    private fun getUrbanAreas() = viewModelScope.launch {
        when (val result = mainRepository.getUrbanAreas()) {
            is NetworkResult.Success -> {
                result.data?.let {
                    citiesList.addAll(it.links.urbanAreasItems)
                }
            }
            else -> {
                Log.e("Network Error", result.message.toString())
            }
        }
    }
}