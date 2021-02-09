package com.onlinetest.stockbit.bibit.watchlist

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.onlinetest.stockbit.bibit.data.Resource

interface WatchlistUseCase {
    fun getTopTierVolumeFull(): LiveData<Resource<PagedList<CoinItem>>>
}