package com.sulitsa.dev.ledgerlink.presentation.info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sulitsa.dev.ledgerlink.domain.usecase.FindCorrespondence
import com.sulitsa.dev.ledgerlink.domain.usecase.serialization.DeserializeAccountNumberFromString
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccountNumberInfoViewModel @Inject constructor(
    private val deserializeAccountNumberFromString: DeserializeAccountNumberFromString,
    private val findCorrespondence: FindCorrespondence
) : ViewModel() {

    private val _state = MutableStateFlow(AccountNumberInfoState())
    val state: StateFlow<AccountNumberInfoState> = _state

    fun onEvent(event: AccountNumberInfoEvent) {
        when (event) {
            is AccountNumberInfoEvent.DeserializeAccountNumber -> {
                deserializeAccountNumber(event.serializedAccountNumber)
            }

            is AccountNumberInfoEvent.SearchAccountCorrespondence -> {
                searchAccountCorrespondence(event.searchValue)
            }
        }
    }

    private fun searchAccountCorrespondence(searchValue: String) {
        viewModelScope.launch {
            val correspondence = _state.value.lastDeserializedAccountNumber!!.accountCorrespondences
            val searchResult = findCorrespondence(
                source = correspondence,
                searchValue = searchValue
            )

            _state.update { currentState ->
                currentState.copy(searchedCorrespondence = searchResult)
            }
        }
    }

    private fun deserializeAccountNumber(serializedAccountNumber: String) {
        viewModelScope.launch {
            val accountNumber = deserializeAccountNumberFromString(serializedAccountNumber = serializedAccountNumber)

            _state.update { currentState ->
                currentState.copy(
                    lastDeserializedAccountNumber = accountNumber,
                    searchedCorrespondence = accountNumber.accountCorrespondences
                )
            }
        }
    }
}