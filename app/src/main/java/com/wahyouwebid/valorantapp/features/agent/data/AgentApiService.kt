package com.wahyouwebid.valorantapp.features.agent.data

import com.wahyouwebid.valorantapp.features.agent.data.model.AgentDetailResponse
import com.wahyouwebid.valorantapp.features.agent.data.model.AgentResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AgentApiService {

    @GET("v1/agents/?isPlayableCharacter=true")
    suspend fun getAgents(): AgentResponse

    @GET("v1/agents/{agentUuid}")
    suspend fun getAgentByUuid(@Path("agentUuid") agentUuid: String): AgentDetailResponse
}