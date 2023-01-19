package com.janyel97.nextree.data.model.urbanareas

import com.google.gson.annotations.SerializedName

data class Image(
    @field: SerializedName("mobile")
    val mobile: String,

    @field: SerializedName("web")
    val web: String,
)
