package com.oppo.finance.model.api

import com.oppo.finance.model.bean.DataResponce

open class BaseRepository {

    suspend fun <T : Any> apiCall(call: suspend () -> DataResponce<T>): DataResponce<T> {
        return call.invoke()
    }


}