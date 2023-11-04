package com.wahyouwebid.valorantapp.features.competitivetiers.data

import com.wahyouwebid.valorantapp.features.competitivetiers.data.model.CompetitiveTiersResponse
import retrofit2.http.GET

interface CompetitiveApiService {

    @GET("v1/competitivetiers")
    suspend fun getCompetitiveTiers(): CompetitiveTiersResponse

}