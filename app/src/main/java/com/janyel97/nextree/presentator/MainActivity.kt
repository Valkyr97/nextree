package com.janyel97.nextree.presentator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.janyel97.nextree.data.model.PlaceModel
import com.janyel97.nextree.ui.theme.NextreeTheme
import com.janyel97.nextree.viewmodel.CountriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val countriesViewModel: CountriesViewModel by viewModels()
        setContent {
            NextreeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    if (countriesViewModel.countriesList.isEmpty()) {
                        Loading()
                    } else {
                        MainContent(countriesViewModel.countriesList)
                    }
                }
            }
        }
    }
}

@Composable
fun Loading(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Text(text = "Loading")
    }
}

@Composable
fun MainContent(
    countriesList: List<PlaceModel>
) {
    LazyColumn {
        items(countriesList) {
            Text(text = it.name)
        }
    }
}