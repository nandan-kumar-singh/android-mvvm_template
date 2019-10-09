package com.oppo.finance.ui.fund_details

import androidx.lifecycle.MutableLiveData
import com.oppo.finance.base.BaseViewModel
import com.oppo.finance.core.bean.Fund
import com.oppo.finance.core.bean.User
import com.oppo.finance.core.repository.FundRepository

class FundDetailsViewModel : BaseViewModel() {
    val mFundData: MutableLiveData<Fund> = MutableLiveData()
    val mRegisterUser: MutableLiveData<User> = MutableLiveData()
    val errMsg: MutableLiveData<String> = MutableLiveData()

    private val repository by lazy { FundRepository() }


}