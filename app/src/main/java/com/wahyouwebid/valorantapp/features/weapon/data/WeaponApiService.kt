package com.wahyouwebid.valorantapp.features.weapon.data

import com.wahyouwebid.valorantapp.features.weapon.data.model.WeaponDetailResponse
import com.wahyouwebid.valorantapp.features.weapon.data.model.WeaponsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface WeaponApiService {

    @GET("v1/weapons")
    suspend fun getWeapons(): WeaponsResponse

    @GET("v1/weapons/{weaponUuid}")
    suspend fun getWeaponByUuid(@Path("weaponUuid") weaponUuid: String): WeaponDetailResponse

}