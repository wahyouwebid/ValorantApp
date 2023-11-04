package com.wahyouwebid.valorantapp.features.weapon.di

import com.wahyouwebid.valorantapp.features.weapon.data.WeaponApiService
import com.wahyouwebid.valorantapp.features.weapon.data.WeaponDataRepository
import com.wahyouwebid.valorantapp.features.weapon.domain.WeaponRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class WeaponModule {

    @Provides
    @Singleton
    fun provideDataRepository(service: WeaponApiService): WeaponRepository {
        return WeaponDataRepository(service)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): WeaponApiService {
        return retrofit.create(WeaponApiService::class.java)
    }

}