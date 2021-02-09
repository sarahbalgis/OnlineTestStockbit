package com.onlinetest.stockbit.bibit.utils

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import java.text.DecimalFormat

object Utils {

    fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager: InputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        activity.currentFocus?.windowToken?.apply {
            inputMethodManager.hideSoftInputFromWindow(this, 0)
        }
    }

    fun printDecimalFormat(double: Double): String{
        return DecimalFormat("##.###").format(double).replace(".",",")
    }
}