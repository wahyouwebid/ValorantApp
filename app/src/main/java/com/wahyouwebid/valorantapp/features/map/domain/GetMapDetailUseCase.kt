package com.wahyouwebid.valorantapp.features.map.domain

import com.wahyouwebid.valorantapp.common.Resource
import com.wahyouwebid.valorantapp.features.map.data.model.toMap
import com.wahyouwebid.valorantapp.features.map.domain.model.Map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMapDetailUseCase @Inject constructor(
    private val repository: MapRepositoty
) {
    operator fun invoke(mapUuid: String): Flow<Resource<Map>> = flow {

        try {
            emit(Resource.Loading)
            repository.getMapByUuid(mapUuid).data?.toMap()?.let {
                emit(Resource.Success(it))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}