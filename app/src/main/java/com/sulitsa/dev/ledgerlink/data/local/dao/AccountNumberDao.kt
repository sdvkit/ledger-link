package com.sulitsa.dev.ledgerlink.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountNumberDao {

    @Transaction
    @Query("SELECT * FROM account_numbers")
    fun findAll(): Flow<List<AccountNumberWithCorrespondence>>

    @Transaction
    @Update
    fun update(accountNumber: AccountNumber)
}