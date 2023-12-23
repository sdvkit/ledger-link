package com.sulitsa.dev.ledgerlink.presentation.favourite

import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence

sealed class FavouriteEvent {
    data object GetAccountNumbers : FavouriteEvent()
    class SearchAccountNumber(val searchValue: String) : FavouriteEvent()
    class UpdateAccountNumber(val accountNumber: AccountNumber) : FavouriteEvent()
    class SerializeAccountNumber(val accountNumber: AccountNumberWithCorrespondence) : FavouriteEvent()
}