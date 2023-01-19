package com.janyel97.nextree.data.model.urbanareas

import com.google.gson.annotations.SerializedName

data class DataItem(
    @field: SerializedName("float_value", alternate = ["string_value"])
    val value: String?,

    @field: SerializedName("id")
    val id: String,

    @field: SerializedName("label")
    val label: String,

    @field: SerializedName("type")
    val type: String
)
