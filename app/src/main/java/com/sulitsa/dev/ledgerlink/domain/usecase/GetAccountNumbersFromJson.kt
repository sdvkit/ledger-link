package com.sulitsa.dev.ledgerlink.domain.usecase

import com.sulitsa.dev.ledgerlink.R
import com.sulitsa.dev.ledgerlink.domain.manager.LocalJsonManager
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber
import javax.inject.Inject

class GetAccountNumbersFromJson @Inject constructor(
    private val localJsonManager: LocalJsonManager
) {

    suspend operator fun invoke(): List<AccountNumber> {
        return localJsonManager.readList(
            resId = R.raw.data,
            clazz = AccountNumber::class.java
        )
    }
}