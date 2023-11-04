package com.wahyouwebid.valorantapp.features.competitivetiers.domain

import com.wahyouwebid.valorantapp.common.Resource
import com.wahyouwebid.valorantapp.features.competitivetiers.data.model.TierDto
import com.wahyouwebid.valorantapp.features.competitivetiers.data.model.toTier
import com.wahyouwebid.valorantapp.features.competitivetiers.domain.model.Tier
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCompetitiveTiersUseCase @Inject constructor(
    private val repository: CompetitiveRepository
) {
    operator fun invoke(): Flow<Resource<List<Tier>>> = flow {
        try {
            emit(Resource.Loading)
            repository.getCompetitiveTiers().data?.last()?.tiers?.let { tiers ->
                val tiersTemp = arrayListOf<TierDto>()
                tiers.forEach { tier ->
                    if (tier.rankTriangleUpIcon != null) {
                        tiersTemp.add(tier)
                    }
                }
                emit(Resource.Success(tiersTemp.map { it.toTier() }))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}