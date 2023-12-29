package com.sulitsa.dev.ledgerlink.presentation.info

import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber

sealed class AccountNumberInfoEvent {

    class DeserializeAccountNumber(val serializedAccountNumber: String) : AccountNumberInfoEvent()
    class SearchAccountCorrespondence(val searchValue: String) : AccountNumberInfoEvent()
    class UpdateAccountNumber(val accountNumber: AccountNumber) : AccountNumberInfoEvent()
}