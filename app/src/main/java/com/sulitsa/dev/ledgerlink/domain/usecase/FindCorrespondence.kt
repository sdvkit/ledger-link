package com.sulitsa.dev.ledgerlink.domain.usecase

import com.sulitsa.dev.ledgerlink.domain.model.AccountCorrespondence
import javax.inject.Inject

class FindCorrespondence @Inject constructor() {

    operator fun invoke(
        source: List<AccountCorrespondence>,
        searchValue: String
    ): List<AccountCorrespondence> {
        return source.filter { accountCorrespondence ->
            accountCorrespondence.credit.toString().indexOf(searchValue) != -1 ||
            accountCorrespondence.debit.toString().indexOf(searchValue) != -1 ||
            accountCorrespondence.description.indexOf(searchValue) != -1
        }
    }
}