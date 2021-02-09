package com.onlinetest.stockbit.bibit.view.login

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.onlinetest.stockbit.bibit.R
import com.onlinetest.stockbit.bibit.utils.Utils
import com.onlinetest.stockbit.bibit.databinding.FragmentLoginBinding
import com.onlinetest.stockbit.bibit.utils.EspressoIdlingResource
import com.onlinetest.stockbit.bibit.view.viewBinding
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment: Fragment(R.layout.fragment_login) {
    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtonListener()
        initBackPressed()
        if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
            EspressoIdlingResource.decrement()
        }
    }


    private fun initButtonListener(){
        binding.btnLogin.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.actionNavLoginToMain)
            Utils.hideSoftKeyboard(requireActivity())
        }
        
        binding.btnLoginGoogle.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.actionNavLoginToMain)
            Utils.hideSoftKeyboard(requireActivity())
        }

        binding.btnLoginFacebook.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.actionNavLoginToMain)
            Utils.hideSoftKeyboard(requireActivity())
        }

        binding.btnFingerPrint.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.actionNavLoginToMain)
            Utils.hideSoftKeyboard(requireActivity())
        }
    }


    private fun initBackPressed(){
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().finish()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
}