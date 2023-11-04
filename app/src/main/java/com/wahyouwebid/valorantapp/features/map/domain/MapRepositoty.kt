package com.wahyouwebid.valorantapp.features.map.domain

import com.wahyouwebid.valorantapp.features.map.data.model.MapDetailResponse
import com.wahyouwebid.valorantapp.features.map.data.model.MapsResponse


interface MapRepositoty {

    suspend fun getMaps(): MapsResponse

    suspend fun getMapByUuid(mapUuid: String): MapDetailResponse

}