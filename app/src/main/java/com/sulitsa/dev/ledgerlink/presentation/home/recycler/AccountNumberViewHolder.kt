package com.sulitsa.dev.ledgerlink.presentation.home.recycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sulitsa.dev.ledgerlink.R
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber

class AccountNumberViewHolder(itemView: View) : ViewHolder(itemView) {

    private val accountNumberTextView: TextView =
        itemView.findViewById(R.id.accountNumberTextView)

    fun bind(accountNumber: AccountNumber) {
        accountNumberTextView.text = accountNumber.number.toString()
    }
}
