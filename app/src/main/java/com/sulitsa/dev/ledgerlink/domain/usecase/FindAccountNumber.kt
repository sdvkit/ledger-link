package com.sulitsa.dev.ledgerlink.domain.usecase

import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence
import javax.inject.Inject

class FindAccountNumber @Inject constructor() {

    operator fun invoke(
        source: List<AccountNumberWithCorrespondence>,
        searchValue: String
    ): List<AccountNumberWithCorrespondence> {
        return source.filter { accountNumberWithCorrespondence ->
            with(accountNumberWithCorrespondence.accountNumber) {
                number.toString().indexOf(searchValue) != -1 ||
                name.lowercase().indexOf(searchValue) != -1
            }
        }
    }
}