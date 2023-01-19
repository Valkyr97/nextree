package com.janyel97.nextree.presentator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.janyel97.nextree.R

@Composable
fun Home(
    onStart: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_tree_house),
            contentDescription = stringResource(id = R.string.home_tree_description),
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxHeight(.7f)
        )
        Text(
            text = stringResource(id = R.string.home_text),
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(top = 24.dp)
        )
        Button(
            onClick = onStart,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 36.dp)
        ) {
            Text(text = stringResource(id = R.string.home_start_btn))
        }
    }
}