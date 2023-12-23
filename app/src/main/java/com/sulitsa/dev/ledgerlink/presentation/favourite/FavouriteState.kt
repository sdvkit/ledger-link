package com.sulitsa.dev.ledgerlink.presentation.favourite

import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence

data class FavouriteState(
    val accountNumbers: List<AccountNumberWithCorrespondence> = listOf(),
    val searchedAccountNumbers: List<AccountNumberWithCorrespondence> = accountNumbers,
    val lastSerializedAccountNumber: String = ""
)