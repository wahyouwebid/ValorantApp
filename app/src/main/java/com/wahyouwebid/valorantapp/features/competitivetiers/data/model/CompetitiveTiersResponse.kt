package com.wahyouwebid.valorantapp.features.competitivetiers.data.model

import com.google.gson.annotations.SerializedName

data class CompetitiveTiersResponse(
    @SerializedName("data")
    val data: List<CompetitiveTier>?,
    @SerializedName("status")
    val status: Int?
)