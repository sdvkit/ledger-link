package com.sulitsa.dev.ledgerlink.domain.usecase.serialization

import com.google.gson.Gson
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence
import javax.inject.Inject

class DeserializeAccountNumberFromString @Inject constructor() {

    operator fun invoke(serializedAccountNumber: String): AccountNumberWithCorrespondence {
        return Gson().fromJson(serializedAccountNumber, AccountNumberWithCorrespondence::class.java)
    }
}