package com.onlinetest.stockbit.bibit.module

import com.onlinetest.stockbit.bibit.watchlist.WatchlistInteractor
import com.onlinetest.stockbit.bibit.watchlist.WatchlistUseCase
import org.koin.dsl.module

private val watchlistUseCaseModule = module {
    single<WatchlistUseCase> {
        WatchlistInteractor(watchlistRepository = get())
    }
}

val useCaseModuleList = mutableListOf(
    watchlistUseCaseModule
)