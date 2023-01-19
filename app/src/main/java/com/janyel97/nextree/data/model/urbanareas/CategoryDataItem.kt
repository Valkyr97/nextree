package com.janyel97.nextree.data.model.urbanareas

import com.google.gson.annotations.SerializedName

data class CategoryDataItem(
    @field: SerializedName("data")
    val data: List<DataItem>,

    @field: SerializedName("id")
    val id: String,

    @field: SerializedName("label")
    val label: String

)
