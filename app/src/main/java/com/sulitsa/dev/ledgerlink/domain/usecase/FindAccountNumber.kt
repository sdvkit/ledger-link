package com.sulitsa.dev.ledgerlink.domain.usecase

import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber
import javax.inject.Inject

class FindAccountNumber @Inject constructor() {

    operator fun invoke(
        source: List<AccountNumber>,
        searchValue: String
    ): List<AccountNumber> {
        return source.filter { accountNumber ->
            accountNumber.number.toString().indexOf(searchValue) != -1 ||
            accountNumber.name.lowercase().indexOf(searchValue) != -1
        }
    }
}