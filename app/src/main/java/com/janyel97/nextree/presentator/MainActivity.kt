package com.janyel97.nextree.presentator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.janyel97.nextree.data.model.CountryItemModel
import com.janyel97.nextree.ui.theme.NextreeTheme
import com.janyel97.nextree.presentator.countries.CountriesList
import com.janyel97.nextree.presentator.countries.CountryDetail
import com.janyel97.nextree.viewmodels.CountriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NextreeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "countriesList"
                    ) {
                        composable("countriesList") {
                            val countriesVM = hiltViewModel<CountriesViewModel>()
                            CountriesList(
                                countriesViewModel = countriesVM
                            ) { id ->
                                navController.navigate("country/$id")
                            }
                        }
                        composable("country/{countryId}") {
                            CountryDetail(
                                countryId = it.arguments?.getString("countryId")
                            )
                        }
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
    countriesList: List<CountryItemModel>
) {
    LazyColumn {
        items(countriesList) {
            Text(text = it.name)
        }
    }
}