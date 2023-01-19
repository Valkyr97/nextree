package com.janyel97.nextree.presentator.cities

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.janyel97.nextree.presentator.cities.components.CityItem
import com.janyel97.nextree.utils.hrefToId
import com.janyel97.nextree.viewmodels.CitiesViewModel

@Composable
fun CitiesList(
    citiesViewModel: CitiesViewModel,
    modifier: Modifier = Modifier,
    onNavigateToCityDetails: (id: String) -> Unit,
) {
    val context = LocalContext.current

    if (!citiesViewModel.error.isNullOrBlank()) {
        Toast.makeText(context, citiesViewModel.error, Toast.LENGTH_SHORT).show()
    }

    if (citiesViewModel.citiesList.isEmpty()) {
        Text(text = "Loading...")
    } else {
        Column(
            modifier = modifier
        ) {
            Surface(
                elevation = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Cities List",
                    style = MaterialTheme.typography.h3,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            LazyColumn(
            ) {
                items(citiesViewModel.citiesList) {
                    CityItem(
                        name = it.name,
                        navigateToCity = {
                            onNavigateToCityDetails(
                                it.href.hrefToId()
                            )
                        }
                    )
                }
            }
        }
    }
}
