package com.oppo.finance

import android.app.Application
import android.content.Context
import com.oppo.finance.model.bean.User
import kotlin.properties.Delegates


class App : Application() {

    companion object {
        var context: Context by Delegates.notNull()
        lateinit var CURRENT_USER: User
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}