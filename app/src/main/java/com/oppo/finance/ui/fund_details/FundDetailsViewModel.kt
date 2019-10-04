package com.oppo.finance.ui.fund_details

import androidx.lifecycle.MutableLiveData
import com.oppo.finance.base.BaseViewModel
import com.oppo.finance.model.bean.Fund

class FundDetailsViewModel :BaseViewModel(){
    val mFundData: MutableLiveData<Fund> = MutableLiveData()


}