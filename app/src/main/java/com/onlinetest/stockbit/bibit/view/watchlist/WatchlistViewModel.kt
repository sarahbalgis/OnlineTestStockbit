package com.onlinetest.stockbit.bibit.view.watchlist

import androidx.lifecycle.ViewModel
import com.onlinetest.stockbit.bibit.view.RefreshableLiveData
import com.onlinetest.stockbit.bibit.watchlist.WatchlistUseCase

class WatchlistViewModel constructor(private val watchlistUseCase: WatchlistUseCase): ViewModel() {

    val topTierVolumeFull by lazy { RefreshableLiveData { watchlistUseCase.getTopTierVolumeFull() } }

}