package com.janyel97.nextree.viewmodels

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.janyel97.nextree.data.repository.MainRepository
import com.janyel97.nextree.di.CityId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CityDetailViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    @CityId cityId: String
) : ViewModel(), LifecycleObserver {


    init {
//        getCityDetails(cityId)
        Log.e("ID", cityId)
    }

    private fun getCityDetails(cityId: String) {
        TODO("Not yet implemented")
    }
}