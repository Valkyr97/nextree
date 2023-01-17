package com.janyel97.nextree.data.model

import com.google.gson.annotations.SerializedName

data class CountriesResponseModel(
    @field:SerializedName("_links")
    val links: CountryItems
)

data class CountryItems(
    @field:SerializedName("country:items")
    val countryItems: List<CountryItemModel>
)

data class CountryItemModel(
    @field:SerializedName("href")
    val href: String,

    @field:SerializedName("name")
    val name: String,
)


