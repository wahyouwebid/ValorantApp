package com.wahyouwebid.valorantapp.features.map.di

import com.wahyouwebid.valorantapp.features.map.data.MapApiService
import com.wahyouwebid.valorantapp.features.map.data.MapDataRepository
import com.wahyouwebid.valorantapp.features.map.domain.MapRepositoty
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MapModule {

    @Provides
    @Singleton
    fun provideDataRepository(service: MapApiService): MapRepositoty {
        return MapDataRepository(service)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): MapApiService {
        return retrofit.create(MapApiService::class.java)
    }

}