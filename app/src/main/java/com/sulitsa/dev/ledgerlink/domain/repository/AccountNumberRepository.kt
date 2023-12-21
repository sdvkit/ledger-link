package com.sulitsa.dev.ledgerlink.domain.repository

import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence

interface AccountNumberRepository {
    suspend fun observeAccountNumbers(action: (List<AccountNumberWithCorrespondence>) -> Unit)
    suspend fun updateAccountNumber(accountNumber: AccountNumber)
}