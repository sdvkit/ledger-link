package com.sulitsa.dev.ledgerlink.presentation.home.recycler

import androidx.recyclerview.widget.DiffUtil.ItemCallback

class AccountNumberCallback : ItemCallback<AccountNumber>() {

    override fun areItemsTheSame(oldItem: AccountNumber, newItem: AccountNumber): Boolean {
        return oldItem.value == newItem.value
    }

    override fun areContentsTheSame(oldItem: AccountNumber, newItem: AccountNumber): Boolean {
        return oldItem == newItem
    }
}