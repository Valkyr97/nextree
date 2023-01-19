package com.janyel97.nextree.data.model.urbanareas

import com.google.gson.annotations.SerializedName

data class Photo(
    @field: SerializedName("attribution")
    val attribution: Attribution,

    @field: SerializedName("image")
    val image: Image
)
