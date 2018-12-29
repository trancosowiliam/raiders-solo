package com.consultaremedios.base.extensions

import java.text.DecimalFormat
import java.text.NumberFormat

fun String.removeAnnormalWhitespaces() : String {
    return this.trim().replace("\\s+".toRegex(), " ")
}

fun Number.toCurrency(): String {
    val nf = NumberFormat.getCurrencyInstance()
    val decimalFormatSymbols = (nf as DecimalFormat).getDecimalFormatSymbols()
    decimalFormatSymbols.currencySymbol = ""
    nf.decimalFormatSymbols = decimalFormatSymbols

    return nf.format(this)
}