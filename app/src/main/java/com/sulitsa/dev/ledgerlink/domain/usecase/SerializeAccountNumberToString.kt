package com.sulitsa.dev.ledgerlink.domain.usecase

import com.google.gson.Gson
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber
import javax.inject.Inject

class SerializeAccountNumberToString @Inject constructor() {

    operator fun invoke(accountNumber: AccountNumber): String {
        return Gson().toJson(accountNumber)
    }
}