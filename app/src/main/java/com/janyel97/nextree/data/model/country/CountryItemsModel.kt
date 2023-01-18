package com.janyel97.nextree.data.model.country

import com.google.gson.annotations.SerializedName
import com.janyel97.nextree.data.model.common.ItemModel

data class CountryItemsModel(
    @field:SerializedName("country:items")
    val countryItems: List<ItemModel>
)

