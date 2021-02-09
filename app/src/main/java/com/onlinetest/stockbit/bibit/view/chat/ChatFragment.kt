package com.onlinetest.stockbit.bibit.view.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.onlinetest.stockbit.bibit.R
import com.onlinetest.stockbit.bibit.databinding.FragmentEmptyBinding
import com.onlinetest.stockbit.bibit.view.viewBinding

class ChatFragment: Fragment(R.layout.fragment_empty) {
    private val binding by viewBinding(FragmentEmptyBinding::bind)

    private val chatViewModel: ChatViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chatViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textDashboard.text = it
        })
    }
}