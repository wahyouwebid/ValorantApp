package com.wahyouwebid.valorantapp.features.weapon.data

import com.wahyouwebid.valorantapp.features.weapon.data.model.WeaponDetailResponse
import com.wahyouwebid.valorantapp.features.weapon.data.model.WeaponsResponse
import com.wahyouwebid.valorantapp.features.weapon.domain.WeaponRepository

class WeaponDataRepository(
    private val apiService: WeaponApiService
): WeaponRepository {

    override suspend fun getWeapons(): WeaponsResponse {
        return apiService.getWeapons()
    }

    override suspend fun getWeaponByUuid(weaponUuid: String): WeaponDetailResponse {
        return apiService.getWeaponByUuid(weaponUuid)
    }

}