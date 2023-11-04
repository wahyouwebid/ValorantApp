package com.wahyouwebid.valorantapp.features.agent.data.model

import com.google.gson.annotations.SerializedName

data class AgentDetailResponse(
    @SerializedName("data")
    val data: AgentDto?,
    @SerializedName("status")
    val status: Int?
)