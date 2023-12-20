package com.sulitsa.dev.ledgerlink.presentation.home.recycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sulitsa.dev.ledgerlink.R
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence

class AccountNumberViewHolder(itemView: View) : ViewHolder(itemView) {

    private val accountNumberTextView: TextView =
        itemView.findViewById(R.id.accountNumberTextView)

    private val accountNumberNameTextView: TextView =
        itemView.findViewById(R.id.accountNumberNameTextView)

    fun bind(accountNumberWithCorrespondence: AccountNumberWithCorrespondence) {
        with (accountNumberWithCorrespondence.accountNumber) {
            accountNumberTextView.text = number.toString()
            accountNumberNameTextView.text = name
        }
    }
}
