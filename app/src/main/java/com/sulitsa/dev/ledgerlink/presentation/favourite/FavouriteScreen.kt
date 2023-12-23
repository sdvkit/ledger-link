package com.sulitsa.dev.ledgerlink.presentation.favourite

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
import com.sulitsa.dev.ledgerlink.R
import com.sulitsa.dev.ledgerlink.databinding.FavouriteScreenBinding
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence
import com.sulitsa.dev.ledgerlink.presentation.home.recycler.AccountNumbersAdapter
import com.sulitsa.dev.ledgerlink.presentation.injectDependencies
import com.sulitsa.dev.ledgerlink.presentation.navigateTo
import com.sulitsa.dev.ledgerlink.util.Constants
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavouriteScreen : Fragment() {

    @Inject
    lateinit var favouriteViewModel: FavouriteViewModel

    private lateinit var binding: FavouriteScreenBinding
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
        binding = FavouriteScreenBinding.inflate(inflater)
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
            favouriteViewModel.state.collect { state ->
                accountNumbersAdapter.submitList(state.searchedAccountNumbers)
            }
        }
    }

    private fun configureSearchBar() {
        binding.searchBarEditText.addTextChangedListener { searchValue ->
            val event = FavouriteEvent.SearchAccountNumber(searchValue = searchValue.toString())
            favouriteViewModel.onEvent(event)
        }
    }

    private fun configureAccountNumbersRecyclerView() {
        accountNumbersAdapter = AccountNumbersAdapter(
            context = requireContext(),
            onItemClicked = { accountNumber ->
                onAccountNumberItemClicked(accountNumber)
            },
            onIsFavouriteClicked = { accountNumber ->
                onIsFavouriteButtonClicked(accountNumber)
            }
        )

        with (binding.accountNumbersRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext(), androidx.recyclerview.widget.RecyclerView.VERTICAL, false)
            adapter = accountNumbersAdapter
        }
    }

    private fun onIsFavouriteButtonClicked(accountNumber: AccountNumber) {
        val event = FavouriteEvent.UpdateAccountNumber(accountNumber = accountNumber)
        favouriteViewModel.onEvent(event)
    }

    private fun onAccountNumberItemClicked(accountNumber: AccountNumberWithCorrespondence) {
        navigateTo(
            resId = R.id.action_homeScreen_to_accountNumberInfoScreen,
            args = Bundle().apply {
                val event = FavouriteEvent.SerializeAccountNumber(accountNumber = accountNumber)
                favouriteViewModel.onEvent(event)

                val serializedAccountNumber = favouriteViewModel.state.value.lastSerializedAccountNumber
                putString(Constants.ACCOUNT_NUMBER_PARAM, serializedAccountNumber)
            }
        )
    }
}