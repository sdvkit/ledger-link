package com.sulitsa.dev.ledgerlink.presentation.info.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sulitsa.dev.ledgerlink.R
import com.sulitsa.dev.ledgerlink.domain.model.AccountCorrespondence

class AccountCorrespondenceAdapter(
    context: Context
) : ListAdapter<AccountCorrespondence, AccountCorrespondenceViewHolder>(AccountCorrespondenceCallback()) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountCorrespondenceViewHolder {
        val view: View = inflater.inflate(R.layout.correspondence_card, parent, false)
        return AccountCorrespondenceViewHolder(itemView = view)
    }

    override fun onBindViewHolder(holder: AccountCorrespondenceViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}