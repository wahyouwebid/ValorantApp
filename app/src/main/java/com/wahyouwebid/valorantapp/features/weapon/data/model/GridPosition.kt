package com.wahyouwebid.valorantapp.features.weapon.data.model

import com.google.gson.annotations.SerializedName

data class GridPosition(
    @SerializedName("column")
    val column: Int?,
    @SerializedName("row")
    val row: Int?
)