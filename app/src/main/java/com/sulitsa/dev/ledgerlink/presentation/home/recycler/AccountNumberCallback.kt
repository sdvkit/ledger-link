package com.sulitsa.dev.ledgerlink.presentation.home.recycler

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber

class AccountNumberCallback : ItemCallback<AccountNumber>() {

    override fun areItemsTheSame(oldItem: AccountNumber, newItem: AccountNumber): Boolean {
        return oldItem.number == newItem.number
    }

    override fun areContentsTheSame(oldItem: AccountNumber, newItem: AccountNumber): Boolean {
        return oldItem == newItem
    }
}