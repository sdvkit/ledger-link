package com.sulitsa.dev.ledgerlink.presentation.info

import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber

data class AccountNumberInfoState(
    val lastDeserializedAccountNumber: AccountNumber? = null
)