package com.janyel97.nextree.presentator.cities

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.janyel97.nextree.viewmodels.CityDetailViewModel
import com.janyel97.nextree.R
import com.janyel97.nextree.presentator.cities.components.FactCard

@Composable
fun CityDetails(
    viewModel: CityDetailViewModel,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    if (!viewModel.error.isNullOrBlank()) {
        Toast.makeText(context, viewModel.error, Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary)
        ) {
            IconButton(
                onClick = onNavigateBack,
                modifier = Modifier
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Text(
                text = viewModel.fullName,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.width(24.dp))
        }
        AsyncImage(
            model = viewModel.image,
            placeholder = painterResource(id = R.drawable.placeholder),
            contentScale = ContentScale.FillWidth,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.45f)
        )
        Text(
            stringResource(id = R.string.city_details_title),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.primary)
        )
        if (viewModel.detailCategoriesList.isNotEmpty()) {
            LazyVerticalGrid(columns = GridCells.Fixed(1)) {
                items(
                    viewModel.detailCategoriesList
                ) { category ->
                    if (category.data.isNotEmpty()) {
                        category.data.filter { item -> !item.value.isNullOrBlank() }.let {
                            if (it.isNotEmpty()) {
                                FactCard(
                                    label = category.label,
                                    facts = it,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
