package com.wahyouwebid.valorantapp.features.agent.presentation.agentdetail

import com.wahyouwebid.valorantapp.features.agent.domain.model.Agent

data class AgentDetailState constructor(
    val isLoading: Boolean = false,
    val agent: Agent? = null,
    val error: String = ""
)