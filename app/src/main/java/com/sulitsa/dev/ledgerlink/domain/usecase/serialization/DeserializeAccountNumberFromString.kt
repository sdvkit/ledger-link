package com.sulitsa.dev.ledgerlink.domain.usecase.serialization

import com.google.gson.Gson
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber
import javax.inject.Inject

class DeserializeAccountNumberFromString @Inject constructor() {

    operator fun invoke(serializedAccountNumber: String): AccountNumber {
        return Gson().fromJson(serializedAccountNumber, AccountNumber::class.java)
    }
}