package com.janyel97.nextree.data.model.urbanareas

import com.google.gson.annotations.SerializedName

data class UrbanAreaDetailsResponseModel(
    @field: SerializedName("categories")
    val categories: List<CategoryDataItem>
)
