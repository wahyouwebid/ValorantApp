package com.wahyouwebid.valorantapp.features.map.data

import com.wahyouwebid.valorantapp.features.map.data.model.MapDetailResponse
import com.wahyouwebid.valorantapp.features.map.data.model.MapsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MapApiService {

    @GET("v1/maps")
    suspend fun getMaps(): MapsResponse

    @GET("v1/maps/{mapUuid}")
    suspend fun getMapByUuid(@Path("mapUuid") mapUuid: String): MapDetailResponse


}