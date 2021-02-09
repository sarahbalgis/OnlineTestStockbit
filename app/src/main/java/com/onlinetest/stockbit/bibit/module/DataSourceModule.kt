package com.onlinetest.stockbit.bibit.module

import com.onlinetest.stockbit.bibit.data.AppExecutors
import com.onlinetest.stockbit.bibit.network.RemoteDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single { RemoteDataSource(get()) }
}

val appExecutorModule = module {
    single { AppExecutors() }
}

val dataSourceModuleList = mutableListOf(
    remoteDataSourceModule,
    appExecutorModule
)