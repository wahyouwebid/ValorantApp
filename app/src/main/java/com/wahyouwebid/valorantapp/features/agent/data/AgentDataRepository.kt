package com.wahyouwebid.valorantapp.features.agent.data

import com.wahyouwebid.valorantapp.features.agent.data.model.AgentDetailResponse
import com.wahyouwebid.valorantapp.features.agent.data.model.AgentResponse
import com.wahyouwebid.valorantapp.features.agent.domain.AgentRepository
import javax.inject.Inject

class AgentDataRepository @Inject constructor(
    private val apiService: AgentApiService
): AgentRepository {

    override suspend fun getAgents(): AgentResponse = apiService.getAgents()

    override suspend fun getAgentByUuid(agentUuid: String): AgentDetailResponse = apiService.getAgentByUuid(agentUuid)

}