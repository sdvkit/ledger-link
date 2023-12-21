package com.sulitsa.dev.ledgerlink.presentation.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sulitsa.dev.ledgerlink.R
import com.sulitsa.dev.ledgerlink.databinding.OnboardScreenBinding
import com.sulitsa.dev.ledgerlink.presentation.navigateTo

class OnboardScreen : Fragment() {

    private lateinit var binding: OnboardScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OnboardScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.startButton.setOnClickListener {
            navigateTo(resId = R.id.action_onboardScreen_to_homeScreen)
        }
    }
}