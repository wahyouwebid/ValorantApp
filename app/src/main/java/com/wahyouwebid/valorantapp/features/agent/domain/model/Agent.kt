package com.wahyouwebid.valorantapp.features.agent.domain.model

import com.wahyouwebid.valorantapp.features.agent.data.model.Ability
import com.wahyouwebid.valorantapp.features.agent.data.model.Role

data class Agent(
    val abilities: List<Ability>,
    val description: String,
    val displayIcon: String,
    val displayName: String,
    val fullPortrait: String,
    val role: Role?,
    val uuid: String
)