package com.sulitsa.dev.ledgerlink.data.repository

import com.sulitsa.dev.ledgerlink.data.local.dao.AccountNumberDao
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence
import com.sulitsa.dev.ledgerlink.domain.repository.AccountNumberRepository
import javax.inject.Inject

class AccountNumberRepositoryImpl @Inject constructor(
    private val accountNumberDao: AccountNumberDao
) : AccountNumberRepository {

    override suspend fun observeAccountNumbers(action: (List<AccountNumberWithCorrespondence>) -> Unit) {
        accountNumberDao.findAll().collect { accountNumbers -> action(accountNumbers) }
    }

    override suspend fun updateAccountNumber(accountNumber: AccountNumber) {
        accountNumberDao.update(accountNumber)
    }
}