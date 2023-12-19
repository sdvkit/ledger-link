package com.sulitsa.dev.ledgerlink.presentation

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sulitsa.dev.ledgerlink.LedgerLinkApp
import com.sulitsa.dev.ledgerlink.presentation.home.HomeScreen

fun Fragment.navigateTo(resId: Int) {
    findNavController().navigate(resId)
}

fun Screen.injectDependencies() {
    val appComponent = (requireActivity().applicationContext as LedgerLinkApp).appComponent

    when (this) {
        is HomeScreen -> {
            appComponent.inject(this)
        }
    }
}