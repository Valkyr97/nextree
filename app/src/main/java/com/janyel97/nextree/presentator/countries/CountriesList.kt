package com.janyel97.nextree.presentator.countries

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.janyel97.nextree.presentator.countries.components.CountryItem
import com.janyel97.nextree.utils.hrefToId
import com.janyel97.nextree.viewmodels.CountriesViewModel

@Composable
fun CountriesList(
    countriesViewModel: CountriesViewModel,
    modifier: Modifier = Modifier,
    onNavigateToCountryDetails: (id: String) -> Unit,
) {
    if (countriesViewModel.countriesList.isEmpty()) {
        Text(text = "Loading")
    } else {
        LazyColumn(
            modifier = modifier
        ) {
            items(countriesViewModel.countriesList) { country ->
                CountryItem(
                    countryName = country.name,
                    navigateToCountry = {
                        onNavigateToCountryDetails(
                            country.href.hrefToId()
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountriesListPreview() {
    CountriesList(
        countriesViewModel = viewModel(),
        onNavigateToCountryDetails = {}
    )
}