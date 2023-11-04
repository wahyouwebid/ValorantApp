package com.wahyouwebid.valorantapp.features.weapon.presentation.weapondetail

import com.wahyouwebid.valorantapp.features.weapon.domain.model.Weapon

data class WeaponDetailState constructor(
    val isLoading: Boolean = false,
    val weapon: Weapon? = null,
    val error: String = ""
)