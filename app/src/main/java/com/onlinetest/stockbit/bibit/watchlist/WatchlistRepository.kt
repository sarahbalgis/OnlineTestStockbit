package com.onlinetest.stockbit.bibit.watchlist

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.onlinetest.stockbit.bibit.data.AppExecutors
import com.onlinetest.stockbit.bibit.data.DictionaryDataFactory
import com.onlinetest.stockbit.bibit.data.OnlyNetworkBoundResourceLiveData
import com.onlinetest.stockbit.bibit.data.Resource
import com.onlinetest.stockbit.bibit.network.RemoteDataSource
import com.onlinetest.stockbit.bibit.network.repository.ApiResponse
import com.onlinetest.stockbit.bibit.network.repository.IWatchlistRepository

class WatchlistRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val appExecutors: AppExecutors
): IWatchlistRepository {

    override fun getTopTierVolumeFull(): LiveData<Resource<PagedList<CoinItem>>> {
        var nextPage = 1
        var networkBound: OnlyNetworkBoundResourceLiveData<PagedList<CoinItem>, WatchlistResponse>?= null
        val dataFactory = DictionaryDataFactory(mutableListOf(),
            object : DictionaryDataFactory.CallBackListener<CoinItem>{
                override fun callBackAfter(
                    params: PageKeyedDataSource.LoadParams<Int>,
                    callback: PageKeyedDataSource.LoadCallback<Int, CoinItem>
                ) {
                    appExecutors.mainThread().execute {
                        if(nextPage <= 5){
                            networkBound?.fetchFromNetwork()
                        }
                    }
                }

                override fun callBackBefore(
                    params: PageKeyedDataSource.LoadParams<Int>,
                    callback: PageKeyedDataSource.LoadCallback<Int, CoinItem>
                ) {

                }

            })

        networkBound = object :OnlyNetworkBoundResourceLiveData<PagedList<CoinItem>, WatchlistResponse>(appExecutors){
            override fun createCall(): LiveData<ApiResponse<WatchlistResponse>> {
                return remoteDataSource.getTopTierVolumeFull(nextPage)
            }

            override fun convertToResultType(remoteData: WatchlistResponse): LiveData<PagedList<CoinItem>> {
                nextPage += 1
                dataFactory.updateData(remoteData.data?.toMutableList()?: mutableListOf())
                return LivePagedListBuilder(dataFactory, PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(10)
                    .setPageSize(10)
                    .build()).build()
            }
        }

        return networkBound.asLiveData()
    }
}