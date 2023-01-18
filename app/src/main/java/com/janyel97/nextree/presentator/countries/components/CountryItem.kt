package com.janyel97.nextree.presentator.countries.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CountryItem(
    countryName: String,
    navigateToCountry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clickable { navigateToCountry() }
    ) {
        Text(text = countryName)
    }
}

@Preview(showBackground = true)
@Composable
fun CountryItemPreview() {
    CountryItem(
        countryName = "Country",
        navigateToCountry = {}
    )
}