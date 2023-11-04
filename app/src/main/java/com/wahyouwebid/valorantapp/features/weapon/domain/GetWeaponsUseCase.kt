package com.wahyouwebid.valorantapp.features.weapon.domain

import com.wahyouwebid.valorantapp.common.Resource
import com.wahyouwebid.valorantapp.features.weapon.data.model.toWeapon
import com.wahyouwebid.valorantapp.features.weapon.domain.model.Weapon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeaponsUseCase @Inject constructor(
    private val repository: WeaponRepository
) {
    operator fun invoke(): Flow<Resource<List<Weapon>>> = flow {

        try {
            emit(Resource.Loading)
            repository.getWeapons().data?.map { it.toWeapon() }?.let {
                emit(Resource.Success(it))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}