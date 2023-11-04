package com.wahyouwebid.valorantapp.features.map.data.model

import com.google.gson.annotations.SerializedName

data class MapsResponse(
    @SerializedName("data")
    val data: List<MapDto>?,
    @SerializedName("status")
    val status: Int?
)