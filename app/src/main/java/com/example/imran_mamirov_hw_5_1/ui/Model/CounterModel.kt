package com.example.imran_mamirov_hw_5_1.ui.Model

class CounterModel {

    private var  count = 0

    fun inc() {
        count++
    }

    fun dec() {
        count--
    }

    fun getResult() = count
}