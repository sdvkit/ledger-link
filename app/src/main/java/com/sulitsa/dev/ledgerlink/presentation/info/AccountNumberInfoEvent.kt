package com.sulitsa.dev.ledgerlink.presentation.info

sealed class AccountNumberInfoEvent {

    class DeserializeAccountNumber(val serializedAccountNumber: String) : AccountNumberInfoEvent()
}