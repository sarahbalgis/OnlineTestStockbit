package com.onlinetest.stockbit.bibit.module

import com.onlinetest.stockbit.bibit.network.repository.IWatchlistRepository
import com.onlinetest.stockbit.bibit.watchlist.WatchlistRepository
import org.koin.dsl.module

private val watchlistRepositoryModule = module {
    single<IWatchlistRepository> { WatchlistRepository(get(), get()) }
}


val repositoryModuleList = mutableListOf(
    watchlistRepositoryModule
)