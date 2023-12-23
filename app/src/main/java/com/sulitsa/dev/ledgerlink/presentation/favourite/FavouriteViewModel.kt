package com.sulitsa.dev.ledgerlink.presentation.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumberWithCorrespondence
import com.sulitsa.dev.ledgerlink.domain.usecase.FindAccountNumber
import com.sulitsa.dev.ledgerlink.domain.usecase.ObserveAccountNumbers
import com.sulitsa.dev.ledgerlink.domain.usecase.UpdateAccountNumber
import com.sulitsa.dev.ledgerlink.domain.usecase.serialization.SerializeAccountNumberToString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavouriteViewModel @Inject constructor(
    private val findAccountNumber: FindAccountNumber,
    private val observeAccountNumbers: ObserveAccountNumbers,
    private val updateAccountNumber: UpdateAccountNumber,
    private val serializeAccountNumberToString: SerializeAccountNumberToString
) : ViewModel() {

    private val _state = MutableStateFlow(FavouriteState())
    val state: StateFlow<FavouriteState> = _state

    init {
        onEvent(FavouriteEvent.GetAccountNumbers)
    }

    fun onEvent(event: FavouriteEvent) {
        when (event) {
            is FavouriteEvent.GetAccountNumbers -> {
                getAccountNumbers()
            }

            is FavouriteEvent.SearchAccountNumber -> {
                searchAccountNumbers(event.searchValue)
            }

            is FavouriteEvent.UpdateAccountNumber -> {
                updateLocalAccountNumber(event.accountNumber)
            }

            is FavouriteEvent.SerializeAccountNumber -> {
                serializeAccountNumber(event.accountNumber)
            }
        }
    }

    private fun serializeAccountNumber(accountNumber: AccountNumberWithCorrespondence) {
        viewModelScope.launch {
            val serializedAccountNumber = serializeAccountNumberToString(accountNumber = accountNumber)

            _state.update { currentState ->
                currentState.copy(lastSerializedAccountNumber = serializedAccountNumber)
            }
        }
    }

    private fun updateLocalAccountNumber(accountNumber: AccountNumber) {
        CoroutineScope(Dispatchers.IO).launch {
            updateAccountNumber(accountNumber = accountNumber)
        }
    }

    private fun searchAccountNumbers(searchValue: String) {
        viewModelScope.launch {
            val searchResult = findAccountNumber(
                source = _state.value.accountNumbers,
                searchValue = searchValue
            )

            _state.update { currentState ->
                currentState.copy(searchedAccountNumbers = searchResult)
            }
        }
    }

    private fun getAccountNumbers() {
        viewModelScope.launch {
            observeAccountNumbers { accountNumbers ->
                _state.update { currentState ->
                    currentState.copy(
                        accountNumbers = filterAccountNumbers(accountNumbers = accountNumbers),
                        searchedAccountNumbers = filterAccountNumbers(accountNumbers = accountNumbers)
                    )
                }
            }
        }
    }

    private fun filterAccountNumbers(
        accountNumbers: List<AccountNumberWithCorrespondence>
    ): List<AccountNumberWithCorrespondence> {
        return accountNumbers.filter { accountNumberWithCorrespondence ->
            accountNumberWithCorrespondence.accountNumber.isFavourite
        }
    }
}