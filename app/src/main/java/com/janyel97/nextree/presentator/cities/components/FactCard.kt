package com.janyel97.nextree.presentator.cities.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.janyel97.nextree.data.model.urbanareas.DataItem

@Composable
fun FactCard(
    label: String,
    facts: List<DataItem>,
    modifier: Modifier = Modifier,
) {
    Surface(
        elevation = 4.dp,
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
            )
            facts
                .forEach {
                    Column(
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    ) {
                        Text(
                            text = "${it.label.removeSuffix(".")}:",
                            style = MaterialTheme.typography.subtitle2
                        )
                        Text(text = it.value.toString())
                    }

                }
        }
    }
}


@Preview(showBackground = true)
@Composable
internal fun FactCardPreview() {
    val facts: List<DataItem> = listOf(
        DataItem(
            id = "LGBT-DETAIL-ADOPTION",
            label = "LGBT adoption rights",
            value = "N/A",
            type = "string"
        ),
        DataItem(
            id = "LGBT-DETAIL-AGE-OF-CONSENT",
            label = "LGBT age of consent",
            value = "✔ Equal",
            type = "string"
        ),
        DataItem(
            id = "LGBT-DETAIL-CHANGING-GENDER",
            label = "LGBT gender changing rights",
            value = "✔ Legal, but requires surgery",
            type = "string"
        ),
        DataItem(
            id = "LGBT-DETAIL-CONVERSION-THERAPY",
            label = "LGBT conversion therapy regulations",
            value = "✔ Banned",
            type = "string"
        ),
        DataItem(
            id = "LGBT-DETAIL-DISCRIMINATION",
            label = "LGBT discrimination legality",
            value = "✔ Illegal",
            type = "string"
        ),
        DataItem(
            id = "LGBT-DETAIL-DONATING-BLOOD",
            label = "LGBT blood donation regulations",
            value = "✖ Banned (1-year deferral)",
            type = "string"
        )
    )
    FactCard(
        label = "Preview Label", facts = facts
    )
}
