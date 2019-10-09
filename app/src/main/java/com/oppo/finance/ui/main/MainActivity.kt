package com.oppo.finance.ui.main

import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.oppo.finance.R
import com.oppo.finance.base.BaseActivity
import com.oppo.finance.utils.NotificationData
import com.oppo.finance.utils.Preference
import com.oppo.finance.utils.bigTextStyle
import com.oppo.finance.utils.showNotification
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var isLogin by Preference(Preference.IS_LOGIN, false)
    private var userJson by Preference(Preference.USER_GSON, "")

    private val titleList = arrayOf(getString(R.string.home), "Settings", "Profile")
    private val fragmentList = arrayListOf<Fragment>()
    private val homeFragment by lazy { HomeFragment() }
    private val homeFragment1 by lazy { HomeFragment() }
    private val homeFragment2 by lazy { HomeFragment() }


    init {
        fragmentList.add(homeFragment)
        fragmentList.add(homeFragment1)
        fragmentList.add(homeFragment2)
    }


    override fun initView() {
        initViewPager()
        mToolBar.title = getString(R.string.app_name)
        mToolBar.setNavigationOnClickListener { drawerLayout.openDrawer(GravityCompat.START) }
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.menu.findItem(R.id.nav_exit).isVisible = isLogin
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

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
                id = 2,
                title = "Header Notification Big Text ",
                content = "Content of the notification",
                style = bigTextStyle("I have developed many android application and I faced this same thing every time to write the logic of failure cases and I made this utils code and converted into library. Actually using this library user don’t need to think over the failure cases logic.")
            )
        )

    }

    private fun initViewPager() {
        viewPager.offscreenPageLimit = titleList.size
        viewPager.adapter = object : androidx.fragment.app.FragmentPagerAdapter(
            supportFragmentManager,
            BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        ) {
            override fun getItem(position: Int) = fragmentList[position]

            override fun getCount() = titleList.size

            override fun getPageTitle(position: Int) = titleList[position]

        }
        viewPager.isHorizontalScrollBarEnabled = false
        tabLayout.setupWithViewPager(viewPager)
    }


}