package com.onlinetest.stockbit.bibit.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.onlinetest.stockbit.bibit.network.repository.ApiResponse

abstract class OnlyNetworkBoundResourceLiveData <ResultType, RequestType>(private val mExecutors: AppExecutors) {
    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        fetchFromNetwork()
    }

    protected open fun onFetchFailed(message: String, throwable: Throwable) {}

    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>

    protected abstract fun convertToResultType(remoteData: RequestType): LiveData<ResultType>

    fun fetchFromNetwork() {
        val apiResponse = createCall()
        result.value = Resource.Loading()
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            when (response) {
                is ApiResponse.Success -> mExecutors.diskIO().execute {
                    mExecutors.mainThread().execute {
                        result.addSource(convertToResultType(response.data)) { newData ->
                            result.value = Resource.Success(newData)
                        }
                    }
                }

                is ApiResponse.Empty -> mExecutors.mainThread().execute {
                    result.value = Resource.Empty()
                }

                is ApiResponse.Error -> {
                    onFetchFailed(response.errorException.message?:"", response.errorException)
                    mExecutors.mainThread().execute {
                        result.value = Resource.Error(response.errorException.message ?: "",
                            response.errorException)
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<Resource<ResultType>> = result

    fun asMutableLiveData(): MutableLiveData<Resource<ResultType>> = result
}
