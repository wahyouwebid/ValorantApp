package com.wahyouwebid.valorantapp.features.agent.domain

import com.wahyouwebid.valorantapp.features.agent.data.model.AgentDetailResponse
import com.wahyouwebid.valorantapp.features.agent.data.model.AgentResponse

interface AgentRepository {

    suspend fun getAgents(): AgentResponse

    suspend fun getAgentByUuid(agentUuid: String): AgentDetailResponse

}