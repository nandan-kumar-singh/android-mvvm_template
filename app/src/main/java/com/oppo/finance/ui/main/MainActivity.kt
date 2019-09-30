package com.oppo.finance.ui.main

import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.oppo.finance.R
import com.oppo.finance.base.BaseActivity
import com.oppo.finance.ui.login.LoginActivity
import com.oppo.finance.utils.Preference
import com.oppo.finance.utils.startKtxActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var isLogin by Preference(Preference.IS_LOGIN, false)
    private var userJson by Preference(Preference.USER_GSON, "")

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                startKtxActivity<LoginActivity>()
            }

            R.id.nav_exit -> exit()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun exit() {
        drawerLayout.closeDrawer(GravityCompat.START)
//        MaterialDialog(this).show {
//            title = getString(R.string.sign_out)
//            message(text = getString(R.string.log_out_prompt))
//            positiveButton(text = getString(R.string.yes)) {
//                isLogin = false
//                userJson = ""
//                navigationView.menu.findItem(R.id.nav_exit).isVisible = isLogin
//            }
//            negativeButton(text = getString(R.string.no))
//        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {

    }

    override fun initView() {
        mainToolBar.setNavigationOnClickListener { drawerLayout.openDrawer(GravityCompat.START) }
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.menu.findItem(R.id.nav_exit).isVisible = isLogin

        if (!isLogin)
            startKtxActivity<LoginActivity>()

    }


}