package com.onlinetest.stockbit.bibit.view.stream

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.onlinetest.stockbit.bibit.R
import com.onlinetest.stockbit.bibit.databinding.FragmentEmptyBinding
import com.onlinetest.stockbit.bibit.view.viewBinding
import org.koin.android.viewmodel.ext.android.viewModel

class StreamFragment : Fragment(R.layout.fragment_empty) {

    private val binding by viewBinding(FragmentEmptyBinding::bind)

    private val streamViewModel: StreamViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        streamViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textDashboard.text = it
        })
    }
}