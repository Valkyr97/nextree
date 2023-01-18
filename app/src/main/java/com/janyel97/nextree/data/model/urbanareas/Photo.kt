package com.janyel97.nextree.data.model.urbanareas

import com.google.gson.annotations.SerializedName
import com.janyel97.nextree.data.model.common.Attribution
import com.janyel97.nextree.data.model.common.Image

data class Photo(
    @field: SerializedName("attribution")
    val attribution: Attribution,

    @field: SerializedName("image")
    val image: Image
)
