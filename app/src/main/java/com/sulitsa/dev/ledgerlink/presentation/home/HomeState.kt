package com.sulitsa.dev.ledgerlink.presentation.home

import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence

data class HomeState(
    val accountNumbers: List<AccountNumberWithCorrespondence> = listOf(),
    val searchedAccountNumbers: List<AccountNumberWithCorrespondence> = accountNumbers
)