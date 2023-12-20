package com.sulitsa.dev.ledgerlink.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sulitsa.dev.ledgerlink.data.local.dao.AccountNumberDao
import com.sulitsa.dev.ledgerlink.domain.model.AccountCorrespondence
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber

@Database(
    entities = [AccountNumber::class, AccountCorrespondence::class],
    version = 1
)
abstract class DatabaseClient : RoomDatabase() {
    abstract fun accountNumberDao(): AccountNumberDao
}