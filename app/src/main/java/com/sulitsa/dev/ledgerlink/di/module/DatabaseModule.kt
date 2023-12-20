package com.sulitsa.dev.ledgerlink.di.module

import android.content.Context
import androidx.room.Room
import com.sulitsa.dev.ledgerlink.data.local.DatabaseClient
import com.sulitsa.dev.ledgerlink.data.local.dao.AccountNumberDao
import com.sulitsa.dev.ledgerlink.util.DatabaseUtils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabaseClient(
        context: Context
    ): DatabaseClient = Room
        .databaseBuilder(
            context = context,
            klass = DatabaseClient::class.java,
            name = DatabaseUtils.DB_NAME
        )
        .createFromAsset(DatabaseUtils.DB_FILE_PATH)
        .build()

    @Provides
    @Singleton
    fun provideAccountNumberDao(
        databaseClient: DatabaseClient
    ): AccountNumberDao = databaseClient.accountNumberDao()
}