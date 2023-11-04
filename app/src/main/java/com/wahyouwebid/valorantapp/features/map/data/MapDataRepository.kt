package com.wahyouwebid.valorantapp.features.map.data

import com.wahyouwebid.valorantapp.features.map.data.model.MapDetailResponse
import com.wahyouwebid.valorantapp.features.map.data.model.MapsResponse
import com.wahyouwebid.valorantapp.features.map.domain.MapRepositoty

class MapDataRepository(
    private val apiService: MapApiService
): MapRepositoty {

    override suspend fun getMaps(): MapsResponse = apiService.getMaps()

    override suspend fun getMapByUuid(mapUuid: String): MapDetailResponse = apiService.getMapByUuid(mapUuid)

}