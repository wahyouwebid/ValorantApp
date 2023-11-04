package com.wahyouwebid.valorantapp.features.map.data.model

import com.google.gson.annotations.SerializedName

data class MapDetailResponse(
    @SerializedName("data")
    val data: MapDto?,
    @SerializedName("status")
    val status: Int?
)