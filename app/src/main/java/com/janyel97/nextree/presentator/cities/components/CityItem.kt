package com.janyel97.nextree.presentator.cities.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CityItem(
    name: String,
    navigateToCity: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clickable { navigateToCity() }
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CityItemPreview() {
    CityItem(name = "Preview City", navigateToCity = {  })
}