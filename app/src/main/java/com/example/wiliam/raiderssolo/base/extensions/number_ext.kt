package com.consultaremedios.base.extensions

import java.math.BigDecimal

fun Number.roundDown(): Int {
    return toInt()
}

fun Number.roundUp(): Int {
    return bd.setScale(0, BigDecimal.ROUND_UP).toInt()
}

val Number.bd: BigDecimal
    get() = toDouble().toBigDecimal()