package com.janyel97.nextree.data.model.city

import com.google.gson.annotations.SerializedName
import com.janyel97.nextree.data.model.common.Coordinates

data class Location(
    @field: SerializedName("geohash")
    val geohash: String,

    @field: SerializedName("latlon")
    val lat_lon: Coordinates
)