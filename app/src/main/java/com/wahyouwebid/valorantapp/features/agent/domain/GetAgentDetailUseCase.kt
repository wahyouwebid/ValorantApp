package com.wahyouwebid.valorantapp.features.agent.domain

import com.wahyouwebid.valorantapp.common.Resource
import com.wahyouwebid.valorantapp.features.agent.data.model.toAgent
import com.wahyouwebid.valorantapp.features.agent.domain.model.Agent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAgentDetailUseCase @Inject constructor(
    private val repository: AgentRepository
) {
    operator fun invoke(agentUuid: String): Flow<Resource<Agent>> = flow {
        try {
            emit(Resource.Loading)
            repository.getAgentByUuid(agentUuid).data?.toAgent()?.let {
                emit(Resource.Success(it))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}