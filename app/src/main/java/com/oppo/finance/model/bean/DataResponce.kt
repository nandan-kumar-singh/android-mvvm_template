package com.oppo.finance.model.bean


data class DataResponce<out T>(val errorCode: Int, val errorMsg: String, val data: T)