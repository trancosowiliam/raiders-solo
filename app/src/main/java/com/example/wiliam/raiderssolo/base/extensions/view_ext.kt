package com.consultaremedios.base.extensions

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.text.style.StyleSpan
import android.view.View
import android.widget.TextView

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun TextView.onAfterTextChangedListener(function: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            function.invoke(s?.toString() ?: "")
        }
    })
}

fun TextView.setContrastText(text: String, contrast: String) {

    val spannable = SpannableStringBuilder(text)

    contrast.removeAnnormalWhitespaces().split(" ").forEach { str ->
        var currentIndex = text.indexOf(str, ignoreCase = true)

        while (currentIndex >= 0) {
            spannable.setSpan(StyleSpan(Typeface.BOLD), currentIndex, currentIndex + str.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            currentIndex = text.indexOf(str, currentIndex + 1, true)
        }
    }

    this.text = spannable
}

var View.isVisibility: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

//fun ImageView.loadImage(photoUrl: String, circle: Boolean = false) {
//    Glide.with(context)
//            .applyDefaultRequestOptions(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA))
//            .load(photoUrl)
//            .apply { if (circle) this.apply(RequestOptions.circleCropTransform()) }
//            .into(this)
//}

fun Drawable.toBitmap(): Bitmap {
    return when (this) {
        is BitmapDrawable -> this.bitmap
        else -> {
            if (this.intrinsicWidth <= 0 || this.intrinsicHeight <= 0) {
                Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)
            } else {
                Bitmap.createBitmap(this.intrinsicWidth, this.intrinsicHeight, Bitmap.Config.ARGB_8888)
            }
        }
    }.apply {
        val canvas = Canvas(this)
        this@toBitmap.setBounds(0, 0, canvas.width, canvas.height)
        this@toBitmap.draw(canvas)
    }
}