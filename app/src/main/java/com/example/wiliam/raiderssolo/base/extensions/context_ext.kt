package com.consultaremedios.base.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

fun Activity.cleanFocus() {
    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = currentFocus
    if (view == null)
        view = View(this)

    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.toast(str:String) {
    Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
}