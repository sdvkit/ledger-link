package com.sulitsa.dev.ledgerlink.presentation.info

import com.sulitsa.dev.ledgerlink.domain.model.AccountCorrespondence
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence

data class AccountNumberInfoState(
    val lastDeserializedAccountNumber: AccountNumberWithCorrespondence? = null,
    val searchedCorrespondence: List<AccountCorrespondence> = listOf()
)