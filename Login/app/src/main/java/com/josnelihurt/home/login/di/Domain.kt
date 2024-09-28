package com.josnelihurt.home.login.di

import com.josnelihurt.home.login.domain.interactors.AuthInteractor
import com.josnelihurt.home.login.domain.interactors.AuthInteractorImpl
import com.josnelihurt.home.login.domain.interactors.SettingInteractor
import com.josnelihurt.home.login.domain.interactors.SettingInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceLayerModule {

    @Binds
    abstract fun bindAuthService(
        authServiceImpl: AuthInteractorImpl
    ): AuthInteractor
    @Binds
    abstract fun bindSettingService(
        settingServiceImpl: SettingInteractorImpl
    ): SettingInteractor
}
