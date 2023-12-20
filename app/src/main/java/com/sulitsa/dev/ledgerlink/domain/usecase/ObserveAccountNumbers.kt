package com.sulitsa.dev.ledgerlink.domain.usecase

import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence
import com.sulitsa.dev.ledgerlink.domain.repository.AccountNumberRepository
import javax.inject.Inject

class ObserveAccountNumbers @Inject constructor(
    private val accountNumberRepository: AccountNumberRepository
) {

    suspend operator fun invoke(action: (List<AccountNumberWithCorrespondence>) -> Unit) {
        accountNumberRepository.observeAccountNumbers(action)
    }
}