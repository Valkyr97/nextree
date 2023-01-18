package com.janyel97.nextree.data.model.common

import com.google.gson.annotations.SerializedName

data class Image(
    @field: SerializedName("mobile")
    val mobile: String,

    @field: SerializedName("web")
    val web: String,
)
