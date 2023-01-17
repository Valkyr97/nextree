package com.janyel97.nextree.presentator.cities

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.janyel97.nextree.presentator.cities.components.CityItem
import com.janyel97.nextree.viewmodels.CitiesViewModel

@Composable
fun CitiesList(
    citiesViewModel: CitiesViewModel,
    modifier: Modifier = Modifier
) {
    if (citiesViewModel.citiesList.isEmpty()) {
        Text(text = "Loading")
    } else {
        LazyColumn(
            modifier = modifier
        ) {
            items(citiesViewModel.citiesList) {
                CityItem(
                    name = it.full_name.substringBefore(',')
                )
            }
        }
    }
}