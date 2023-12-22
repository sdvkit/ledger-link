package com.sulitsa.dev.ledgerlink.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sulitsa.dev.ledgerlink.domain.model.AccountNumber
import com.sulitsa.dev.ledgerlink.domain.usecase.FindAccountNumber
import com.sulitsa.dev.ledgerlink.domain.usecase.ObserveAccountNumbers
import com.sulitsa.dev.ledgerlink.domain.usecase.serialization.SerializeAccountNumberToString
import com.sulitsa.dev.ledgerlink.domain.usecase.UpdateAccountNumber
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val findAccountNumber: FindAccountNumber,
    private val observeAccountNumbers: ObserveAccountNumbers,
    private val updateAccountNumber: UpdateAccountNumber,
    private val serializeAccountNumberToString: SerializeAccountNumberToString
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state

    init {
        onEvent(HomeEvent.GetAccountNumbers)
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.GetAccountNumbers -> {
                getAccountNumbers()
            }

            is HomeEvent.SearchAccountNumber -> {
                searchAccountNumbers(event.searchValue)
            }

            is HomeEvent.UpdateAccountNumber -> {
                updateLocalAccountNumber(event.accountNumber)
            }

            is HomeEvent.SerializeAccountNumber -> {
                serializeAccountNumber(event.accountNumber)
            }
        }
    }

    private fun serializeAccountNumber(accountNumber: AccountNumber) {
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
                        accountNumbers = accountNumbers,
                        searchedAccountNumbers = accountNumbers
                    )
                }
            }
        }
    }
}