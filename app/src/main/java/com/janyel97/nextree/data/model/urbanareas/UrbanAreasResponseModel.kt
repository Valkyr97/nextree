package com.janyel97.nextree.data.model.urbanareas

import com.google.gson.annotations.SerializedName
import com.janyel97.nextree.data.model.common.ItemModel

data class UrbanAreasResponseModel(
    @field: SerializedName("ua:item")
    val urbanAreasItems: List<ItemModel>
)