package com.sulitsa.dev.ledgerlink.domain.usecase.serialization

import com.google.gson.Gson
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence
import javax.inject.Inject

class SerializeAccountNumberToString @Inject constructor() {

    operator fun invoke(accountNumber: AccountNumberWithCorrespondence): String {
        return Gson().toJson(accountNumber)
    }
}