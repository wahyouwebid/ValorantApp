package com.wahyouwebid.valorantapp.features.weapon.domain

import com.wahyouwebid.valorantapp.common.Resource
import com.wahyouwebid.valorantapp.features.weapon.data.model.Skin
import com.wahyouwebid.valorantapp.features.weapon.data.model.toWeapon
import com.wahyouwebid.valorantapp.features.weapon.domain.model.Weapon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeaponDetailUseCase @Inject constructor(
    private val repository: WeaponRepository
) {
    fun getWeaponDetailByUuid(weaponUuid: String): Flow<Resource<Weapon>> = flow {

        try {
            emit(Resource.Loading)
            repository.getWeaponByUuid(weaponUuid).data?.toWeapon()?.let { weapon ->
                val skinsTemp = arrayListOf<Skin>()
                weapon.skins?.forEach { skin ->

                    if (skin.displayIcon.isNullOrEmpty()
                            .not() && skin.displayName.orEmpty().contains("Standard").not()
                    ) {
                        skinsTemp.add(skin)
                    }
                }
                weapon.skins = skinsTemp
                emit(Resource.Success(weapon))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}