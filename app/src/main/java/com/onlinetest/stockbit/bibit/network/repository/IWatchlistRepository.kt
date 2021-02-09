package com.onlinetest.stockbit.bibit.network.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.onlinetest.stockbit.bibit.data.Resource
import com.onlinetest.stockbit.bibit.watchlist.CoinItem

interface IWatchlistRepository {
    fun getTopTierVolumeFull(): LiveData<Resource<PagedList<CoinItem>>>
}