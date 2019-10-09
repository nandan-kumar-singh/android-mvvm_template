package com.oppo.finance.core.repository

import com.oppo.finance.core.api.BaseRepository
import com.oppo.finance.core.api.RetrofitClient
import com.oppo.finance.core.bean.DataResponse
import com.oppo.finance.core.bean.Fund
import com.oppo.finance.core.bean.User


class FundRepository : BaseRepository() {

    suspend fun getFund(fundName :String): DataResponse<Fund> {
        //if(isNetworkAvailable(App.context)) {
            return apiCall {
                RetrofitClient.instance.getFund()
            }
       // }

//       var response: DataResponse<Fund>
//        {
//           response= DataResponse(errorCode = 10,errorMsg = "21212",data = Fund("323232"))
//        }
//
//        response.errorCode=200
//        response.data=Fund("ICICI Life")
//        response.errorMsg="Server error 404!"
//        return response
    }

    suspend fun register(userName: String, passWord: String): DataResponse<User> {
        return apiCall {
            RetrofitClient.instance.register(userName, passWord, passWord)
        }
    }

}