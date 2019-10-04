package com.oppo.finance.ui.main

import android.os.Build
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.oppo.finance.App
import com.oppo.finance.R
import com.oppo.finance.base.BaseActivity
import com.oppo.finance.utils.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var isLogin by Preference(Preference.IS_LOGIN, false)
    private var userJson by Preference(Preference.USER_GSON, "")

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                //startKtxActivity<Fund>()
            }
            R.id.nav_sign -> {
                //startKtxActivity<SignatureActivity>()
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

    override fun getLayoutResId() = R.layout.activity_main

    override fun initData() {
        showNotification(
            context = this,
            data = NotificationData(
                id = 1,
                title = "Header Notification Short Notes",
                content = "Content of the notification"
            )
        )
        showNotification(
            context = this,
            data = NotificationData(
                id = 2,
                title = "Header Notification Big Text ",
                content = "Content of the notification",
                style = bigTextStyle("I have developed many android application and I faced this same thing every time to write the logic of failure cases and I made this utils code and converted into library. Actually using this library user don’t need to think over the failure cases logic.")
            )
        )

        showNotification(
            context = this,
            data = NotificationData(
                id = 3,
                title = "Header Notification Big picture",
                content = "Content of the notification",
                style = bigPictureStyle(
                    context = this,
                    image = R.drawable.img
                )
            )

        )

    }

    override fun initView() {
        mToolBar.title = getString(R.string.app_name)
        mToolBar.setNavigationOnClickListener { drawerLayout.openDrawer(GravityCompat.START) }
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.menu.findItem(R.id.nav_exit).isVisible = isLogin

        // if (!isLogin)
        //startKtxActivity<LoginActivity>()

    }


}