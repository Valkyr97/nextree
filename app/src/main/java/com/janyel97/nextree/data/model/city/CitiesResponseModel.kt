package com.janyel97.nextree.data.model.city

import com.google.gson.annotations.SerializedName

data class CitiesResponseModel(
    @field: SerializedName("_embedded")
    val data: CitySearch
)

data class CitySearch(
    @field: SerializedName("city:search-results")
    val cities: List<CityItemModel>
)

data class CityItemModel(

    @field: SerializedName("_links")
    val links: CityLinks,

    @field: SerializedName("matching_full_name")
    val full_name: String,

//    @field: SerializedName("matching_alternate_names")
//    val alt_names: List<String>,
)

data class CityLinks(
    @field: SerializedName("city:item")
    val cityLink: CityLinkItem
)

data class CityLinkItem(
    @field: SerializedName("href")
    val href: String
)


