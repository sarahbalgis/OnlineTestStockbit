package com.onlinetest.stockbit.bibit.view.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.onlinetest.stockbit.bibit.R
import com.onlinetest.stockbit.bibit.databinding.FragmentSplashBinding
import com.onlinetest.stockbit.bibit.utils.EspressoIdlingResource
import com.onlinetest.stockbit.bibit.view.viewBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {
    private val binding by viewBinding(FragmentSplashBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        EspressoIdlingResource.increment()
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.actionNavSplashtoLogin)
        }, 2000)
    }
}
