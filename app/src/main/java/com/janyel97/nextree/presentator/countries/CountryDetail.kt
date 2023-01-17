package com.janyel97.nextree.presentator.countries

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CountryDetail(
    countryId: String?,
    modifier: Modifier = Modifier
) {
    countryId?.let {
        Text(text = (it), modifier = modifier)
    }
}