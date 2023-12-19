package com.sulitsa.dev.ledgerlink.di.module

import android.content.Context
import com.sulitsa.dev.ledgerlink.data.manager.LocalJsonManagerImpl
import com.sulitsa.dev.ledgerlink.domain.manager.LocalJsonManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ManagerModule {

    @Provides
    @Singleton
    fun provideLocalJsonManager(
        context: Context
    ): LocalJsonManager = LocalJsonManagerImpl(context)
}