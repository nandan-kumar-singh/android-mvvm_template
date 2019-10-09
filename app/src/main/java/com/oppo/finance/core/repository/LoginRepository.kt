package com.oppo.finance.core.repository

import com.oppo.finance.core.api.BaseRepository
import com.oppo.finance.core.api.RetrofitClient
import com.oppo.finance.core.bean.DataResponse
import com.oppo.finance.core.bean.User


class LoginRepository : BaseRepository() {

    suspend fun login(userName: String, passWord: String): DataResponse<User> {
        return apiCall {
            RetrofitClient.instance.login(userName, passWord)
        }
    }

    suspend fun register(userName: String, passWord: String): DataResponse<User> {
        return apiCall {
            RetrofitClient.instance.register(userName, passWord, passWord)
        }
    }

}