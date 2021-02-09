package com.onlinetest.stockbit.bibit.module

import com.onlinetest.stockbit.bibit.view.chat.ChatViewModel
import com.onlinetest.stockbit.bibit.view.watchlist.WatchlistViewModel
import com.onlinetest.stockbit.bibit.view.portfolio.PortfolioViewModel
import com.onlinetest.stockbit.bibit.view.search.SearchViewModel
import com.onlinetest.stockbit.bibit.view.stream.StreamViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val streamViewModelModule = module {
    viewModel { StreamViewModel() }
}

private val searchViewModelModule = module {
    viewModel { SearchViewModel() }
}

private val chatViewModelModule = module {
    viewModel { ChatViewModel() }
}

private val portfolioViewModelModule = module {
    viewModel { PortfolioViewModel() }
}

private val watchlistViewModelModule = module {
    viewModel { WatchlistViewModel(watchlistUseCase = get()) }
}



val viewModelModuleList = mutableListOf(
    streamViewModelModule,
    searchViewModelModule,
    chatViewModelModule,
    portfolioViewModelModule,
    watchlistViewModelModule
)