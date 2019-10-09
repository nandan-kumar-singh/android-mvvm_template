package com.oppo.finance.ui.main

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.oppo.finance.R
import com.oppo.finance.base.BaseFragment
import com.oppo.finance.utils.datePickerDialog
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    override fun getLayoutResId() = R.layout.fragment_home

    override fun initView() {

        tvDate.setOnClickListener {
            val date = MutableLiveData<String>()
            date.observe(this, Observer {
                tvDate.text = date.value
            })

            datePickerDialog(context as FragmentActivity, date)
        }

    }

    override fun initData() {
    }
}