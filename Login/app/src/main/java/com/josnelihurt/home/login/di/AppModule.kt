package com.josnelihurt.home.login.di

import android.content.Context
import com.josnelihurt.home.login.data.repositories.LoginRepositoryImpl
import com.josnelihurt.home.login.data.repositories.SettingsRepositoryImpl
import com.josnelihurt.home.login.domain.repositories.LoginRepository
import com.josnelihurt.home.login.domain.repositories.SettingsRepository
import com.josnelihurt.home.login.domain.interactors.AuthInteractor
import com.josnelihurt.home.login.domain.interactors.AuthInteractorImpl
import com.josnelihurt.home.login.domain.interactors.SettingInteractor
import com.josnelihurt.home.login.domain.interactors.SettingInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }
}


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
