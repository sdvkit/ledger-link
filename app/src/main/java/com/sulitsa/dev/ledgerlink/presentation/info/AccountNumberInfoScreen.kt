package com.sulitsa.dev.ledgerlink.presentation.info

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sulitsa.dev.ledgerlink.databinding.AccountNumberInfoScreenBinding
import com.sulitsa.dev.ledgerlink.util.Constants

class AccountNumberInfoScreen : Fragment() {

    private lateinit var binding: AccountNumberInfoScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AccountNumberInfoScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ser = arguments?.getString(Constants.ACCOUNT_NUMBER_PARAM)
        Log.i("______", ser.toString())
    }


}