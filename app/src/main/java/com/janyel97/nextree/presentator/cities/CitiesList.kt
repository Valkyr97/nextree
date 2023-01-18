package com.janyel97.nextree.presentator.cities

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.janyel97.nextree.presentator.cities.components.CityItem
import com.janyel97.nextree.utils.hrefToId
import com.janyel97.nextree.viewmodels.CitiesViewModel
import com.janyel97.nextree.viewmodels.CityDetailViewModel

@Composable
fun CitiesList(
    citiesViewModel: CitiesViewModel,
    modifier: Modifier = Modifier,
    onNavigateToCityDetails: (id: String) -> Unit,
) {
    if (citiesViewModel.citiesList.isEmpty()) {
        Text(text = "Loading...")
    } else {
        LazyColumn(
            modifier = modifier
        ) {
            items(citiesViewModel.citiesList) {
                val citiDetailVM = hiltViewModel<CityDetailViewModel>()
                CityItem(
                    name = it.name,
                    cityViewModel = citiDetailVM,
                    navigateToCity = {
                        onNavigateToCityDetails(
                            hrefToId(it.href)
                        )
                    }
                )
            }
        }
    }
}