package com.sulitsa.dev.ledgerlink.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sulitsa.dev.ledgerlink.databinding.HomeScreenBinding
import com.sulitsa.dev.ledgerlink.presentation.home.recycler.AccountNumbersAdapter
import com.sulitsa.dev.ledgerlink.presentation.injectDependencies
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeScreen : Fragment() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    private lateinit var binding: HomeScreenBinding
    private lateinit var accountNumbersAdapter: AccountNumbersAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectDependencies()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureAccountNumbersRecyclerView()
        configureSearchBar()
        configureState()
        configureNavigationBar()
    }

    private fun configureNavigationBar() {
        val navController = findNavController()
        val bottomNavigationView = binding.bottomNavigationView
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

    private fun configureState() {
        lifecycleScope.launch {
            homeViewModel.state.collect { state ->
                accountNumbersAdapter.submitList(state.searchedAccountNumbers)
            }
        }
    }

    private fun configureSearchBar() {
        binding.searchBarEditText.addTextChangedListener { searchValue ->
            val event = HomeEvent.SearchAccountNumber(searchValue = searchValue.toString())
            homeViewModel.onEvent(event)
        }
    }

    private fun configureAccountNumbersRecyclerView() {
        accountNumbersAdapter = AccountNumbersAdapter(requireContext())

        with (binding.accountNumbersRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = accountNumbersAdapter
        }
    }
}