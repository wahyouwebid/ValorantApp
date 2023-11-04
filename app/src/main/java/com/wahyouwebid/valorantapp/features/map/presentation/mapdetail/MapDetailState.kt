package com.wahyouwebid.valorantapp.features.map.presentation.mapdetail

import com.wahyouwebid.valorantapp.features.map.domain.model.Map

data class MapDetailState constructor(
    val isLoading: Boolean = false,
    val map: Map? = null,
    val error: String = ""
)