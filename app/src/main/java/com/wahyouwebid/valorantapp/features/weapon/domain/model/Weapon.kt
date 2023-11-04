package com.wahyouwebid.valorantapp.features.weapon.domain.model

import com.wahyouwebid.valorantapp.features.weapon.data.model.Skin
import com.wahyouwebid.valorantapp.features.weapon.data.model.WeaponStats

data class Weapon(
    val category: String?,
    val displayIcon: String?,
    val displayName: String?,
    var skins: List<Skin>?,
    val uuid: String?,
    val weaponStats: WeaponStats?
)
