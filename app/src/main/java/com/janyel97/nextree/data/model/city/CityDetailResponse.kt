package com.janyel97.nextree.data.model.city

import com.google.gson.annotations.SerializedName
import com.janyel97.nextree.data.model.common.ItemModel

data class CityDetailResponse(
    @field: SerializedName("full_name")
    val full_name: String,

    @field: SerializedName("geoname_id")
    val geoname_id: String,

    @field: SerializedName("name")
    val name: String,

    @field: SerializedName("population")
    val population: String,

    @field: SerializedName("city:country")
    val city_country: ItemModel,

    @field: SerializedName("city:timezone")
    val city_timezone: ItemModel,

    @field: SerializedName("city:urban_area")
    val city_urban_area: ItemModel,

    @field: SerializedName("location")
    val location: Location
)
