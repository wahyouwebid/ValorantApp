package com.wahyouwebid.valorantapp.features.competitivetiers.data

import com.wahyouwebid.valorantapp.features.competitivetiers.data.model.CompetitiveTiersResponse
import com.wahyouwebid.valorantapp.features.competitivetiers.domain.CompetitiveRepository
import javax.inject.Inject

class CompetitiveDataRepository @Inject constructor(
    private val apiService: CompetitiveApiService
): CompetitiveRepository {

    override suspend fun getCompetitiveTiers(): CompetitiveTiersResponse = apiService.getCompetitiveTiers()

}