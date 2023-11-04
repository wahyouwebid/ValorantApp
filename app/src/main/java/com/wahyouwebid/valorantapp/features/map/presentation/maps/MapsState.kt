package com.wahyouwebid.valorantapp.features.map.presentation.maps

import com.wahyouwebid.valorantapp.features.map.domain.model.Map

data class MapsState(
    val isLoading: Boolean = false,
    val maps: List<Map> = emptyList(),
    val error: String = ""
)