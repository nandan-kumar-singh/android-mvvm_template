package com.oppo.finance.ui.splash

import com.oppo.finance.R
import com.oppo.finance.base.BaseActivity
import com.oppo.finance.ui.main.MainActivity
import com.oppo.finance.utils.startKtxActivity

class SplashActivity : BaseActivity() {
    override fun getLayoutResId() = R.layout.activity_splash

    override fun initView() {
        startKtxActivity<MainActivity>()
    }

    override fun initData() {}

}