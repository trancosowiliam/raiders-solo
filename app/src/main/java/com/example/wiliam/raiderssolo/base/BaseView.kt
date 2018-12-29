package com.consultaremedios.base

interface BaseView<out T : BasePresenter<*>> {
    val presenter: T
}