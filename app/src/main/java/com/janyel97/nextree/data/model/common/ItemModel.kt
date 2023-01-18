package com.janyel97.nextree.data.model.common

import com.google.gson.annotations.SerializedName

data class ItemModel(
    @field: SerializedName("href")
    val href: String,

    @field: SerializedName("name")
    val name: String,
)
