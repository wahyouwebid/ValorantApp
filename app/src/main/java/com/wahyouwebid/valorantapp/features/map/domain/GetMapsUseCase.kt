package com.wahyouwebid.valorantapp.features.map.domain

import com.wahyouwebid.valorantapp.common.Resource
import com.wahyouwebid.valorantapp.features.map.data.model.toMap
import com.wahyouwebid.valorantapp.features.map.domain.model.Map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMapsUseCase @Inject constructor(
    private val repository: MapRepositoty
) {
    operator fun invoke(): Flow<Resource<List<Map>>> = flow {

        try {
            emit(Resource.Loading)
            repository.getMaps().data?.map { it.toMap() }?.let {
                emit(Resource.Success(it))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}