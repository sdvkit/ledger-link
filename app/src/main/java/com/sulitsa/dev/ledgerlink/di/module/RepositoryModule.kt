package com.sulitsa.dev.ledgerlink.di.module

import com.sulitsa.dev.ledgerlink.data.local.dao.AccountNumberDao
import com.sulitsa.dev.ledgerlink.data.repository.AccountNumberRepositoryImpl
import com.sulitsa.dev.ledgerlink.domain.repository.AccountNumberRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAccountNumberRepository(
        accountNumberDao: AccountNumberDao
    ): AccountNumberRepository = AccountNumberRepositoryImpl(accountNumberDao)
}