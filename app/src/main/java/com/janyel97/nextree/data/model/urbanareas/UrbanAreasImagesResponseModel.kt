package com.janyel97.nextree.data.model.urbanareas

import com.google.gson.annotations.SerializedName

data class UrbanAreasImagesResponseModel(
    @field: SerializedName("photos")
    val photos: List<Photo>
)
