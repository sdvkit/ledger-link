package com.sulitsa.dev.ledgerlink.presentation

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.navigateTo(resId: Int) {
    findNavController().navigate(resId)
}