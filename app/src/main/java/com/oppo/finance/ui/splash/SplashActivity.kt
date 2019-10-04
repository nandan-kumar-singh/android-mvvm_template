package com.oppo.finance.ui.splash

import com.oppo.finance.R
import com.oppo.finance.base.BaseActivity
import com.oppo.finance.base.BaseFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseFragment() {
    override fun getLayoutResId() = R.layout.activity_splash

    override fun initView() {
        GlobalScope.launch {
            delay(2000)

            GlobalScope.async {
            }

        }
    }

    override fun initData() {

    }

}