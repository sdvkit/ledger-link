package com.sulitsa.dev.ledgerlink.domain.usecase

import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber
import com.sulitsa.dev.ledgerlink.domain.repository.AccountNumberRepository
import javax.inject.Inject

class UpdateAccountNumber @Inject constructor(
    private val accountNumberRepository: AccountNumberRepository
) {

    suspend operator fun invoke(accountNumber: AccountNumber) {
        accountNumberRepository.updateAccountNumber(accountNumber)
    }
}