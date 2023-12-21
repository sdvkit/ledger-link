package com.sulitsa.dev.ledgerlink.presentation.home.recycler

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sulitsa.dev.ledgerlink.R
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence

class AccountNumberViewHolder(
    itemView: View,
    private val onItemClicked: (AccountNumber) -> Unit,
    private val onIsFavouriteClicked: (AccountNumber) -> Unit
) : ViewHolder(itemView) {

    private val accountNumberTextView: TextView =
        itemView.findViewById(R.id.accountNumberTextView)

    private val accountNumberNameTextView: TextView =
        itemView.findViewById(R.id.accountNumberNameTextView)

    private val isFavouriteCheckBox: CheckBox =
        itemView.findViewById(R.id.isFavouriteCheckBox)

    fun bind(accountNumberWithCorrespondence: AccountNumberWithCorrespondence) {
        with (accountNumberWithCorrespondence.accountNumber) {
            accountNumberTextView.text = number.toString()
            accountNumberNameTextView.text = name
            isFavouriteCheckBox.isChecked = isFavourite

            itemView.setOnClickListener {
                onItemClicked(this)
            }

            isFavouriteCheckBox.setOnCheckedChangeListener { _, isChecked ->
                isFavourite = isChecked
                onIsFavouriteClicked(this)
            }
        }
    }
}
