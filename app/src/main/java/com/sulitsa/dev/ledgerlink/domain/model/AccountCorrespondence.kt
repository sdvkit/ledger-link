package com.sulitsa.dev.ledgerlink.domain.model

data class AccountCorrespondence(
    val debit: Float,
    val credit: Float,
    val description: String
)