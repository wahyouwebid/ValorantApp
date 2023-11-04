package com.wahyouwebid.valorantapp.features.competitivetiers.di

import com.wahyouwebid.valorantapp.features.competitivetiers.data.CompetitiveApiService
import com.wahyouwebid.valorantapp.features.competitivetiers.data.CompetitiveDataRepository
import com.wahyouwebid.valorantapp.features.competitivetiers.domain.CompetitiveRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CompetitiveModule {

    @Provides
    @Singleton
    fun provideDataRepository(service: CompetitiveApiService): CompetitiveRepository {
        return CompetitiveDataRepository(service)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): CompetitiveApiService {
        return retrofit.create(CompetitiveApiService::class.java)
    }

}