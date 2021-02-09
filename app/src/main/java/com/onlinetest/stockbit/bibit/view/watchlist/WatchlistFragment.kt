package com.onlinetest.stockbit.bibit.view.watchlist

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.onlinetest.stockbit.bibit.R
import com.onlinetest.stockbit.bibit.data.Resource
import com.onlinetest.stockbit.bibit.databinding.FragmentWatchlistBinding
import com.onlinetest.stockbit.bibit.watchlist.WatchlistListAdapter
import com.onlinetest.stockbit.bibit.view.viewBinding
import org.koin.android.viewmodel.ext.android.viewModel
import java.net.UnknownHostException

class WatchlistFragment : Fragment(R.layout.fragment_watchlist) {

    private val binding by viewBinding(FragmentWatchlistBinding::bind)

    private val watchlistViewModel: WatchlistViewModel by viewModel()

    private val watchlistListAdapter by lazy { WatchlistListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSwipeListener()
        initRecyclerView()
        initTopTierVolumeFull()
    }

    private fun initSwipeListener(){
        binding.swipeView.setOnRefreshListener {
            watchlistViewModel.topTierVolumeFull.refresh()
            Handler(Looper.getMainLooper()).postDelayed({
                binding.swipeView.isRefreshing = false
            }, 150)
        }
    }

    private fun initRecyclerView(){
        binding.listRecyclerview.adapter = watchlistListAdapter
        binding.listRecyclerview.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL, false)
    }

    private fun initTopTierVolumeFull(){
        watchlistViewModel.topTierVolumeFull.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Loading -> {
                    showLoading()
                }
                is Resource.Success -> {
                    showList()
                    watchlistListAdapter.submitList(it.data)
                }
                is Resource.Error -> {
                    showError()
                    if(it.throwable is UnknownHostException){
                        Toast.makeText(requireContext(), R.string.no_internet_connection, Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun showLoading(){
        requireActivity().runOnUiThread {
            binding.animationView.visibility = View.VISIBLE
            binding.listRecyclerview.visibility = View.GONE
            binding.errorMessageView.visibility = View.GONE
        }
    }

    private fun showList(){
        requireActivity().runOnUiThread{
            binding.animationView.visibility = View.GONE
            binding.listRecyclerview.visibility = View.VISIBLE
            binding.errorMessageView.visibility = View.GONE
        }
    }

    private fun showError(){
        requireActivity().runOnUiThread {
            binding.animationView.visibility = View.GONE
            binding.listRecyclerview.visibility = View.GONE
            binding.errorMessageView.visibility = View.VISIBLE
        }
    }
}