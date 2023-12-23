package com.sulitsa.dev.ledgerlink.presentation.info

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sulitsa.dev.ledgerlink.databinding.AccountNumberInfoScreenBinding
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence
import com.sulitsa.dev.ledgerlink.presentation.injectDependencies
import com.sulitsa.dev.ledgerlink.presentation.navigateUp
import com.sulitsa.dev.ledgerlink.util.Constants
import javax.inject.Inject

class AccountNumberInfoScreen : Fragment() {

    @Inject
    lateinit var accountNumberInfoViewModel: AccountNumberInfoViewModel

    private lateinit var binding: AccountNumberInfoScreenBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectDependencies()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AccountNumberInfoScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureViews()
        configureButtons()
    }

    private fun configureViews() {
        val accountNumber = deserializeAccountNumber()

        with (binding) {
            isFavouriteCheckBox.isChecked = accountNumber.accountNumber.isFavourite
        }
    }

    private fun deserializeAccountNumber(): AccountNumberWithCorrespondence {
        val serializedAccountNumber = requireArguments().getString(Constants.ACCOUNT_NUMBER_PARAM)!!
        val event = AccountNumberInfoEvent.DeserializeAccountNumber(serializedAccountNumber = serializedAccountNumber)
        accountNumberInfoViewModel.onEvent(event)
        return accountNumberInfoViewModel.state.value.lastDeserializedAccountNumber!!
    }

    private fun configureButtons() {
        binding.backButton.setOnClickListener {
            navigateUp()
        }
    }
}