package com.sulitsa.dev.ledgerlink.presentation.info.recycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sulitsa.dev.ledgerlink.R
import com.sulitsa.dev.ledgerlink.domain.model.AccountCorrespondence

class AccountCorrespondenceViewHolder(itemView: View) : ViewHolder(itemView) {

    private val debitTextView: TextView =
        itemView.findViewById(R.id.debitTextView)

    private val creditTextView: TextView =
        itemView.findViewById(R.id.creditTextView)

    private val descriptionTextView: TextView =
        itemView.findViewById(R.id.descriptionTextView)

    fun bind(accountCorrespondence: AccountCorrespondence) {
        with (accountCorrespondence) {
            debitTextView.text = accountCorrespondence.debit.toString()
            creditTextView.text = accountCorrespondence.credit.toString()
            descriptionTextView.text = accountCorrespondence.description
        }
    }
}
