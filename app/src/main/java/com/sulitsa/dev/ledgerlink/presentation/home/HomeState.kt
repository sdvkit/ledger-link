package com.sulitsa.dev.ledgerlink.presentation.home

import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber

data class HomeState(
    val accountNumbers: List<AccountNumber> = listOf(),
    val searchedAccountNumbers: List<AccountNumber> = accountNumbers
)