package com.sulitsa.dev.ledgerlink.domain.model

data class AccountNumber(
    val name: String,
    val number: Float,
    val correspondence: List<AccountCorrespondence>
)