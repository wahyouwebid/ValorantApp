package com.wahyouwebid.valorantapp.features.weapon.data.model

import com.google.gson.annotations.SerializedName
import com.wahyouwebid.valorantapp.features.weapon.domain.model.Weapon

data class WeaponDto(
    @SerializedName("assetPath")
    val assetPath: String?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("defaultSkinUuid")
    val defaultSkinUuid: String?,
    @SerializedName("displayIcon")
    val displayIcon: String?,
    @SerializedName("displayName")
    val displayName: String?,
    @SerializedName("killStreamIcon")
    val killStreamIcon: String?,
    @SerializedName("shopData")
    val shopData: ShopData?,
    @SerializedName("skins")
    var skins: List<Skin>?,
    @SerializedName("uuid")
    val uuid: String?,
    @SerializedName("weaponStats")
    val weaponStats: WeaponStats?
)

fun WeaponDto.toWeapon() = Weapon(
    category = category,
    displayIcon = displayIcon,
    displayName = displayName,
    skins = skins,
    uuid = uuid,
    weaponStats = weaponStats
)