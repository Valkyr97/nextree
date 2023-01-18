package com.janyel97.nextree.data.model.common

import com.google.gson.annotations.SerializedName

data class LinksModel<T>(
    @field:SerializedName("_links")
    val links: T
)
