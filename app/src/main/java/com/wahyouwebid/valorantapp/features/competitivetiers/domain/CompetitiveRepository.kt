package com.wahyouwebid.valorantapp.features.competitivetiers.domain

import com.wahyouwebid.valorantapp.features.competitivetiers.data.model.CompetitiveTiersResponse


interface CompetitiveRepository {

    suspend fun getCompetitiveTiers(): CompetitiveTiersResponse

}