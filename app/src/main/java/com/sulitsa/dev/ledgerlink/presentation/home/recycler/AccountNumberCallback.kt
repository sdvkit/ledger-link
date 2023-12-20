package com.sulitsa.dev.ledgerlink.presentation.home.recycler

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence

class AccountNumberCallback : ItemCallback<AccountNumberWithCorrespondence>() {

    override fun areItemsTheSame(oldItem: AccountNumberWithCorrespondence, newItem: AccountNumberWithCorrespondence): Boolean {
        return oldItem.accountNumber.number == newItem.accountNumber.number
    }

    override fun areContentsTheSame(oldItem: AccountNumberWithCorrespondence, newItem: AccountNumberWithCorrespondence): Boolean {
        return oldItem.accountNumber == newItem.accountNumber
    }
}