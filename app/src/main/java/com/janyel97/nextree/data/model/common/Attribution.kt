package com.janyel97.nextree.data.model.common

import com.google.gson.annotations.SerializedName

data class Attribution(

    @field: SerializedName("license")
    val license: String,

    @field: SerializedName("photographer")
    val photographer: String,

    @field: SerializedName("site")
    val site: String,

    @field: SerializedName("source")
    val source: String
)
