package com.wahyouwebid.valorantapp.features.agent.data.model

import com.google.gson.annotations.SerializedName

data class VoiceLine(
    @SerializedName("maxDuration")
    val maxDuration: Double?,
    @SerializedName("mediaList")
    val mediaList: List<Media>?,
    @SerializedName("minDuration")
    val minDuration: Double?
)