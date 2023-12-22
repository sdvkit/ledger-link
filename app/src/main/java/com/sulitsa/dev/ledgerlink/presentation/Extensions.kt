package com.sulitsa.dev.ledgerlink.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sulitsa.dev.ledgerlink.LedgerLinkApp
import com.sulitsa.dev.ledgerlink.presentation.home.HomeScreen

fun Fragment.navigateTo(resId: Int, args: Bundle? = null) {
    findNavController().navigate(resId, args)
}

fun Fragment.navigateUp() {
    findNavController().navigateUp()
}

fun Fragment.injectDependencies() {
    val appComponent = (requireActivity().applicationContext as LedgerLinkApp).appComponent

    when (this) {
        is HomeScreen -> {
            appComponent.inject(this)
        }
    }
}