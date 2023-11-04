package com.wahyouwebid.valorantapp.features.competitivetiers.presentation

import com.wahyouwebid.valorantapp.features.competitivetiers.domain.model.Tier

data class CompetitiveTiersState(
    val isLoading: Boolean = false,
    val tier: List<Tier> = emptyList(),
    val error: String = ""
)