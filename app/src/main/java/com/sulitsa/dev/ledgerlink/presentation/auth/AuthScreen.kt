package com.sulitsa.dev.ledgerlink.presentation.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sulitsa.dev.ledgerlink.databinding.AuthScreenBinding

class AuthScreen : Fragment() {

    private lateinit var binding: AuthScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AuthScreenBinding.inflate(layoutInflater)
        return binding.root
    }
}