package com.onlinetest.stockbit.bibit.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.onlinetest.stockbit.bibit.view.chat.ChatFragment
import com.onlinetest.stockbit.bibit.view.watchlist.WatchlistFragment
import com.onlinetest.stockbit.bibit.view.portfolio.PortfolioFragment
import com.onlinetest.stockbit.bibit.view.search.SearchFragment
import com.onlinetest.stockbit.bibit.view.stream.StreamFragment

class MainPagerAdapter(fragmentActivity: FragmentActivity):
    FragmentStateAdapter(fragmentActivity) {

    val mainMenuList by lazy {
        listOf(
            WatchlistFragment(),
            StreamFragment(),
            SearchFragment(),
            ChatFragment(),
            PortfolioFragment()
        )
    }

    override fun getItemCount(): Int {
        return mainMenuList.size
    }

    override fun createFragment(position: Int): Fragment {
        return mainMenuList[position]
    }

    inline fun <reified T>getFragmentPosition(): Int{
        for(index in 0..this.mainMenuList.size){
            if(this.mainMenuList[index] is T){
                return index
            }
        }
        return 0
    }
}