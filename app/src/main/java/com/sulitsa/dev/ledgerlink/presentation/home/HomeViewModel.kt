package com.sulitsa.dev.ledgerlink.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sulitsa.dev.ledgerlink.domain.usecase.FindAccountNumber
import com.sulitsa.dev.ledgerlink.domain.usecase.ObserveAccountNumbers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val findAccountNumber: FindAccountNumber,
    private val observeAccountNumbers: ObserveAccountNumbers
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