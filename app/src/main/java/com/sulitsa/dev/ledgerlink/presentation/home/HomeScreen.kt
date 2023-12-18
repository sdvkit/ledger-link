package com.sulitsa.dev.ledgerlink.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sulitsa.dev.ledgerlink.databinding.HomeScreenBinding
import com.sulitsa.dev.ledgerlink.presentation.home.recycler.AccountNumber
import com.sulitsa.dev.ledgerlink.presentation.home.recycler.AccountNumbersAdapter

class HomeScreen : Fragment() {

    private lateinit var binding: HomeScreenBinding
    private lateinit var accountNumbersAdapter: AccountNumbersAdapter
    private var accountNumbersList: List<AccountNumber> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureAccountNumbersRecyclerView()
        configureSearchBar()
    }

    private fun configureSearchBar() {
        binding.searchBarEditText.addTextChangedListener { searchValue ->
            accountNumbersAdapter.submitList(accountNumbersList.filter { accountNumber ->
                accountNumber.value.toString().indexOf(searchValue.toString()) != -1
            })
        }
    }

    private fun configureAccountNumbersRecyclerView() {
        accountNumbersAdapter = AccountNumbersAdapter(requireContext())

        with (binding.accountNumbersRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = accountNumbersAdapter
        }

        accountNumbersAdapter.submitList(accountNumbersList)
    }
}