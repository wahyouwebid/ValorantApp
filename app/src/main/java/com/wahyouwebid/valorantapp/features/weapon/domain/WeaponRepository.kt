package com.wahyouwebid.valorantapp.features.weapon.domain

import com.wahyouwebid.valorantapp.features.weapon.data.model.WeaponDetailResponse
import com.wahyouwebid.valorantapp.features.weapon.data.model.WeaponsResponse

interface WeaponRepository {

    suspend fun getWeapons(): WeaponsResponse

    suspend fun getWeaponByUuid(weaponUuid: String): WeaponDetailResponse

}