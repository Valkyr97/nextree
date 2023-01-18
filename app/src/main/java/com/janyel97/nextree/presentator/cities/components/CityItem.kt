package com.janyel97.nextree.presentator.cities.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.janyel97.nextree.viewmodels.CityDetailViewModel

@Composable
fun CityItem(
    name: String,
    cityViewModel: CityDetailViewModel,
    navigateToCity: () -> Unit,
    modifier: Modifier = Modifier,
    image: String? = null,
    continent: String? = null,
    full_name: String? = null,
) {
    Box(
        modifier = modifier
            .clickable { navigateToCity() }
    ) {
        Text(text = name)
    }
}