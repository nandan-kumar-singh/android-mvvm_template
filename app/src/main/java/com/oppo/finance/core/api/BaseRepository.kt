package com.oppo.finance.core.api

import com.oppo.finance.core.bean.DataResponse

open class BaseRepository {

    suspend fun <T : Any> apiCall(call: suspend () -> DataResponse<T>): DataResponse<T> {
        return call.invoke()
    }


}