package com.onlinetest.stockbit.bibit.watchlist

import android.content.Context
import androidx.startup.Initializer
import com.onlinetest.stockbit.bibit.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class WatchlistInitializer: Initializer<KoinApplication> {
    override fun create(context: Context): KoinApplication {
        return startKoin {
            androidContext(context)
            modules(
                mutableListOf(networkModule).apply {
                    addAll(dataSourceModuleList)
                    addAll(repositoryModuleList)
                    addAll(useCaseModuleList)
                    addAll(viewModelModuleList)
                }
            )
        }
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}