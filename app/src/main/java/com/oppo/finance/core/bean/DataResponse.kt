package com.oppo.finance.core.bean


data class DataResponse<out T>(var errorCode: Int, var errorMsg: String, val data: T)