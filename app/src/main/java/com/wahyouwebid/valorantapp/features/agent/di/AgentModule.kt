package com.wahyouwebid.valorantapp.features.agent.di

import com.wahyouwebid.valorantapp.features.agent.data.AgentApiService
import com.wahyouwebid.valorantapp.features.agent.data.AgentDataRepository
import com.wahyouwebid.valorantapp.features.agent.domain.AgentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AgentModule {

    @Provides
    @Singleton
    fun provideDataRepository(service: AgentApiService): AgentRepository {
        return AgentDataRepository(service)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): AgentApiService {
        return retrofit.create(AgentApiService::class.java)
    }

}