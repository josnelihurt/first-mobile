package com.josnelihurt.home.login.di

import com.josnelihurt.home.login.data.repositories.LoginRepositoryImpl
import com.josnelihurt.home.login.data.repositories.SettingsRepositoryImpl
import com.josnelihurt.home.login.domain.repositories.LoginRepository
import com.josnelihurt.home.login.domain.repositories.SettingsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryLayerModule {

    @Binds
    @Singleton
    abstract fun bindLoginRepository(
        loginRepositoryImpl: LoginRepositoryImpl
    ): LoginRepository
    @Binds
    abstract fun bindSettingsRepository(
        settingRepositoryImpl: SettingsRepositoryImpl
    ): SettingsRepository
}
