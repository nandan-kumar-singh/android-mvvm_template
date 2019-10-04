package com.oppo.finance.ui.login

import androidx.lifecycle.MutableLiveData
import com.oppo.finance.base.BaseViewModel
import com.oppo.finance.model.bean.User
import com.oppo.finance.model.repository.LoginRepository
import com.oppo.finance.utils.executeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class LoginViewModel : BaseViewModel() {

    val mLoginUser: MutableLiveData<User> = MutableLiveData()
    val mRegisterUser: MutableLiveData<User> = MutableLiveData()
    val errMsg: MutableLiveData<String> = MutableLiveData()

    private val repository by lazy { LoginRepository() }

    fun login(userName: String, passWord: String) {
        launch {

            val response = withContext(context = Dispatchers.IO) {
                repository.login(userName, passWord)
            }
            executeResponse(response,
                successBlock = {
                    mLoginUser.value = response.data
                }, errorBlock = {
                    errMsg.value = response.errorMsg
                })
        }
    }

    fun register(userName: String, passWord: String) {
        launch {
            val result = withContext(Dispatchers.IO) { repository.register(userName, passWord) }

            executeResponse(
                result,
                successBlock = { mRegisterUser.value = result.data },
                errorBlock = { errMsg.value = result.errorMsg })
        }
    }



}