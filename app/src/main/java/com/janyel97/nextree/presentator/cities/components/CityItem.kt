package com.janyel97.nextree.presentator.cities.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CityItem(
    name: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Text(text = name)
    }
}