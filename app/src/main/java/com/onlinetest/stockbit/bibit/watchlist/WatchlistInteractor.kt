package com.onlinetest.stockbit.bibit.watchlist

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.onlinetest.stockbit.bibit.data.Resource
import com.onlinetest.stockbit.bibit.network.repository.IWatchlistRepository

class WatchlistInteractor constructor(private val watchlistRepository: IWatchlistRepository): WatchlistUseCase {

    override fun getTopTierVolumeFull(): LiveData<Resource<PagedList<CoinItem>>> {
        return watchlistRepository.getTopTierVolumeFull()
    }

}