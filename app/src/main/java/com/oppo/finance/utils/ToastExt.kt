package com.oppo.finance.utils

import android.app.DatePickerDialog
import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import java.util.*


fun Context.toast(content: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, content, duration).apply {
        show()
    }
}

fun Context.toast(@StringRes id: Int, duration: Int = Toast.LENGTH_SHORT) {
    toast(getString(id), duration)
}

fun Context.longToast(content: String) {
    toast(content, Toast.LENGTH_LONG)
}

fun Context.longToast(@StringRes id: Int) {
    toast(id, Toast.LENGTH_LONG)
}

fun Any.toast(context: Context, content: String, duration: Int = Toast.LENGTH_SHORT) {
    context.toast(content, duration)
}

fun Any.toast(context: Context, @StringRes id: Int, duration: Int = Toast.LENGTH_SHORT) {
    context.toast(id, duration)
}

fun Any.longToast(context: Context, content: String) {
    context.longToast(content)
}

fun Any.longToast(context: Context, @StringRes id: Int) {
    context.longToast(id)
}

/**
 *  Create a LiveDate variable and Observe it
 * val date = MutableLiveData<String>()
 *       date.observe(this, Observer {
 *          tvDate.text = date.value
 *       })
 *
 *      Now call datePickerDialog to get the value
 *           datePickerDialog(
 *                   activity as FragmentActivity, date
 *               )
 */
fun Any.datePickerDialog(context: Context, date: MutableLiveData<String>) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val dpd = DatePickerDialog(
        context,
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            date.value =
                "${calendar.get(Calendar.DAY_OF_MONTH)} ${calendar.get(Calendar.MONTH) + 1} ${calendar.get(
                    Calendar.YEAR
                )}"
        },
        year,
        month,
        day
    )
    dpd.show()
}

