package com.sulitsa.dev.ledgerlink.presentation.home

sealed class HomeEvent {
    data object GetAccountNumbers : HomeEvent()
    class SearchAccountNumber(val searchValue: String) : HomeEvent()
}