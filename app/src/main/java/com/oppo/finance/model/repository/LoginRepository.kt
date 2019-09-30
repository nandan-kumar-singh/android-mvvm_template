package luyao.wanandroid.model.repository

import com.oppo.finance.model.api.BaseRepository
import com.oppo.finance.model.api.RetrofitClient
import com.oppo.finance.model.bean.DataResponce
import com.oppo.finance.model.bean.User


class LoginRepository : BaseRepository() {

    suspend fun login(userName: String, passWord: String): DataResponce<User> {
        return apiCall {
            RetrofitClient.instance.login(userName, passWord)
        }
    }

    suspend fun register(userName: String, passWord: String): DataResponce<User> {
        return apiCall {
            RetrofitClient.instance.register(userName, passWord, passWord)
        }
    }

}