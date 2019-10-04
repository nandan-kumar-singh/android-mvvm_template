package com.oppo.finance

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.oppo.finance.model.bean.User
import kotlin.properties.Delegates


class App : MultiDexApplication() {

    companion object {
        var context: Context by Delegates.notNull()
        lateinit var CURRENT_USER: User
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        MultiDex.install(context)
    }
}