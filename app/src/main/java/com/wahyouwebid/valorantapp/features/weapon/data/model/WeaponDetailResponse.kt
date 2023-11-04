package com.wahyouwebid.valorantapp.features.weapon.data.model

import com.google.gson.annotations.SerializedName

data class WeaponDetailResponse(
    @SerializedName("data")
    val data: WeaponDto?,
    @SerializedName("status")
    val status: Int?
)