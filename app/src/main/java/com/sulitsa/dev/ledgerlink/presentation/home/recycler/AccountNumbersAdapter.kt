package com.sulitsa.dev.ledgerlink.presentation.home.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sulitsa.dev.ledgerlink.R
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence

class AccountNumbersAdapter(
    context: Context
) : ListAdapter<AccountNumberWithCorrespondence, AccountNumberViewHolder>(AccountNumberCallback()) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountNumberViewHolder {
        val view: View = inflater.inflate(R.layout.account_number_item_view, parent, false)
        return AccountNumberViewHolder(view)
    }

    override fun onBindViewHolder(holder: AccountNumberViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}