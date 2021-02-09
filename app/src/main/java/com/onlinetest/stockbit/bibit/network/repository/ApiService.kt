package com.onlinetest.stockbit.bibit.network.repository

import com.onlinetest.stockbit.bibit.watchlist.WatchlistResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

@JvmSuppressWildcards
interface ApiService {
    @GET("data/top/totaltoptiervolfull")
    suspend fun getTopCoins(@QueryMap data: Map<String, Any>): WatchlistResponse
}