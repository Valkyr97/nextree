package com.janyel97.nextree.presentator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.janyel97.nextree.presentator.cities.CitiesList
import com.janyel97.nextree.presentator.cities.CityDetails
import com.janyel97.nextree.ui.theme.NextreeTheme
import com.janyel97.nextree.utils.Constants
import com.janyel97.nextree.viewmodels.CitiesViewModel
import com.janyel97.nextree.viewmodels.CityDetailViewModel
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
                        startDestination = Constants.START_ROUTE
                    ) {
                        composable("citiesList") {
                            val citiesViewModel = hiltViewModel<CitiesViewModel>()
                            CitiesList(
                                citiesViewModel = citiesViewModel,
                            ) { cityId ->
                                navController.navigate("city/$cityId")
                            }
                        }
                        composable("city/{cityId}") {
                            val cityViewModel = hiltViewModel<CityDetailViewModel>()
                            CityDetails(
//                                id = it.arguments?.getString("cityId"),
                                viewModel = cityViewModel,
                                onNavigateBack = { navController.navigate("citiesList") }
                            )
                        }
                        composable("home") {
                            Home(
                                onStart = {
                                    navController.navigate(
                                        "citiesList"
                                    ) {
                                        popUpTo("home") { inclusive = true }
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}