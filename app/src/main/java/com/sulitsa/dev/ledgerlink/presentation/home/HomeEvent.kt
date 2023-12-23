package com.sulitsa.dev.ledgerlink.presentation.home

import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence

sealed class HomeEvent {
    data object GetAccountNumbers : HomeEvent()
    class SearchAccountNumber(val searchValue: String) : HomeEvent()
    class UpdateAccountNumber(val accountNumber: AccountNumber) : HomeEvent()
    class SerializeAccountNumber(val accountNumber: AccountNumberWithCorrespondence) : HomeEvent()
}