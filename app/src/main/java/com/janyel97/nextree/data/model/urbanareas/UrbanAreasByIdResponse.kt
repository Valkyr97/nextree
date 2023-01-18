package com.janyel97.nextree.data.model.urbanareas

import com.google.gson.annotations.SerializedName

data class UrbanAreasByIdResponse(
    @field: SerializedName("continent")
    val continent: String,

    @field: SerializedName("full_name")
    val full_name: String,

    @field: SerializedName("is_government_partner")
    val is_government_partner: Boolean,

    @field: SerializedName("mayor")
    val mayor: String,

    @field: SerializedName("name")
    val name: String,

    @field: SerializedName("slug")
    val slug: String,

    @field: SerializedName("teleport_city_url")
    val teleport_city_url: String,

    @field: SerializedName("ua_id")
    val ua_id: String,

)
