package com.janyel97.nextree.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.janyel97.nextree.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel(), LifecycleObserver {

}