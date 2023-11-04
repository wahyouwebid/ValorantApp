package com.wahyouwebid.valorantapp.features.competitivetiers.data.model

import com.google.gson.annotations.SerializedName
import com.wahyouwebid.valorantapp.features.competitivetiers.domain.model.Tier

data class TierDto(
    @SerializedName("backgroundColor")
    val backgroundColor: String?,
    @SerializedName("color")
    val color: String?,
    @SerializedName("division")
    val division: String?,
    @SerializedName("divisionName")
    val divisionName: String?,
    @SerializedName("largeIcon")
    val largeIcon: String?,
    @SerializedName("rankTriangleDownIcon")
    val rankTriangleDownIcon: Any?,
    @SerializedName("rankTriangleUpIcon")
    val rankTriangleUpIcon: Any?,
    @SerializedName("smallIcon")
    val smallIcon: String?,
    @SerializedName("tier")
    val tier: Int?,
    @SerializedName("tierName")
    val tierName: String?
)

fun TierDto.toTier() = Tier(
    largeIcon = largeIcon,
    tierName = tierName
)