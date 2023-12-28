package com.sulitsa.dev.ledgerlink.presentation.info.recycler

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.sulitsa.dev.ledgerlink.domain.model.AccountCorrespondence

class AccountCorrespondenceCallback : ItemCallback<AccountCorrespondence>() {

    override fun areItemsTheSame(oldItem: AccountCorrespondence, newItem: AccountCorrespondence): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AccountCorrespondence, newItem: AccountCorrespondence): Boolean {
        return oldItem == newItem
    }
}