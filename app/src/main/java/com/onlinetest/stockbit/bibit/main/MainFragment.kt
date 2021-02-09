package com.onlinetest.stockbit.bibit.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.onlinetest.stockbit.bibit.R
import com.onlinetest.stockbit.bibit.databinding.FragmentMainBinding
import com.onlinetest.stockbit.bibit.utils.Utils
import com.onlinetest.stockbit.bibit.view.chat.ChatFragment
import com.onlinetest.stockbit.bibit.view.watchlist.WatchlistFragment
import com.onlinetest.stockbit.bibit.view.portfolio.PortfolioFragment
import com.onlinetest.stockbit.bibit.view.search.SearchFragment
import com.onlinetest.stockbit.bibit.view.stream.StreamFragment
import com.onlinetest.stockbit.bibit.view.viewBinding

class MainFragment : Fragment(R.layout.fragment_main),
    NavigationView.OnNavigationItemSelectedListener {
    private val binding by viewBinding(FragmentMainBinding::bind)

    private val viewPagerAdapter by lazy { MainPagerAdapter(requireActivity())
    }

    @SuppressLint("RtlHardcoded")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBackPressed()
        binding.dashboarViewPager.adapter = viewPagerAdapter
        binding.dashboarViewPager.isUserInputEnabled = false
        binding.navView.setOnNavigationItemSelectedListener(setBottomNavigationListener())
        binding.headerLayout.btnImgMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(Gravity.LEFT)
        }
        binding.navigationDrawerView.setNavigationItemSelectedListener(this)
    }

    private fun setBottomNavigationListener() =
        BottomNavigationView.OnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_watchlist -> showFragment<WatchlistFragment>()
                R.id.nav_stream -> showFragment<StreamFragment>()
                R.id.nav_search -> showFragment<SearchFragment>()
                R.id.nav_chat -> showFragment<ChatFragment>()
                R.id.nav_porto -> showFragment<PortfolioFragment>()
            }
            true
        }

    private inline fun <reified T>showFragment(){
        binding.dashboarViewPager.setCurrentItem(viewPagerAdapter.getFragmentPosition<T>(), false)
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.navExit){
            Navigation.findNavController(requireView()).navigate(R.id.actionNavMainToLogin)
            Utils.hideSoftKeyboard(requireActivity())
        }
        return true
    }
}