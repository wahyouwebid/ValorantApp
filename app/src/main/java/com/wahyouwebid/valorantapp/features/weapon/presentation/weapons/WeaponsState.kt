package com.wahyouwebid.valorantapp.features.weapon.presentation.weapons

import com.wahyouwebid.valorantapp.features.weapon.domain.model.Weapon

data class WeaponsState(
    val isLoading: Boolean = false,
    val weapons: List<Weapon> = emptyList(),
    val error: String = ""
)