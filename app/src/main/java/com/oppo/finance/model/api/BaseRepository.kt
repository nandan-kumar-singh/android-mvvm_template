package com.oppo.finance.model.api

import com.oppo.finance.model.bean.DataResponse

open class BaseRepository {

    suspend fun <T : Any> apiCall(call: suspend () -> DataResponse<T>): DataResponse<T> {
        return call.invoke()
    }


}