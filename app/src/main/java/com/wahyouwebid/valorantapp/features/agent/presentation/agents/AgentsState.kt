package com.wahyouwebid.valorantapp.features.agent.presentation.agents

import com.wahyouwebid.valorantapp.features.agent.domain.model.Agent

data class AgentsState(
    val isLoading: Boolean = false,
    val agents: List<Agent> = emptyList(),
    val error: String = ""
)