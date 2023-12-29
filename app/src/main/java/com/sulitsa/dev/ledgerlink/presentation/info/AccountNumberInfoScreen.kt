package com.sulitsa.dev.ledgerlink.presentation.info

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sulitsa.dev.ledgerlink.databinding.AccountNumberInfoScreenBinding
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence
import com.sulitsa.dev.ledgerlink.presentation.info.recycler.AccountCorrespondenceAdapter
import com.sulitsa.dev.ledgerlink.presentation.injectDependencies
import com.sulitsa.dev.ledgerlink.presentation.navigateUp
import com.sulitsa.dev.ledgerlink.util.Constants
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccountNumberInfoScreen : Fragment() {

    @Inject
    lateinit var accountNumberInfoViewModel: AccountNumberInfoViewModel

    private lateinit var binding: AccountNumberInfoScreenBinding
    private lateinit var accountCorrespondenceAdapter: AccountCorrespondenceAdapter

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
        configureAccountCorrespondenceRecyclerView()
        configureViews()
        configureState()
        configureButtons()
        configureSearchBar()
    }

    private fun configureSearchBar() {
        binding.searchBarEditText.addTextChangedListener { searchValue ->
            val event = AccountNumberInfoEvent.SearchAccountCorrespondence(searchValue = searchValue.toString())
            accountNumberInfoViewModel.onEvent(event)
        }
    }


    private fun configureAccountCorrespondenceRecyclerView() {
        accountCorrespondenceAdapter = AccountCorrespondenceAdapter(context = requireContext())

        with (binding.correspondenceRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = accountCorrespondenceAdapter
        }
    }

    private fun configureState() {
        lifecycleScope.launch {
            accountNumberInfoViewModel.state.collect { state ->
                val correspondence = state.searchedCorrespondence
                accountCorrespondenceAdapter.submitList(correspondence)
            }
        }
    }

    private fun configureViews() {
        val accountNumber = deserializeAccountNumber()

        with (binding) {
            isFavouriteCheckBox.isChecked = accountNumber.accountNumber.isFavourite
            accountNumberTextView.text = accountNumber.accountNumber.number.toString()
            accountNumberNameTextView.text = accountNumber.accountNumber.name
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