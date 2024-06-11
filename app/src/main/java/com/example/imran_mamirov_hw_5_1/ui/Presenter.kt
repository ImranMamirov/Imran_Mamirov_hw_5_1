package com.example.imran_mamirov_hw_5_1.ui

import com.example.imran_mamirov_hw_5_1.ui.Interface.CounterView
import com.example.imran_mamirov_hw_5_1.ui.Model.CounterModel

class Presenter {

    private val model = CounterModel()
    private var view: CounterView? = null

    fun attachView(view: CounterView) {
        this.view = view
    }

    fun onDecrementButtonClicked() {
        model.dec()
        val result = model.getResult()
        view?.updateCount(result)
        checkForSpecialValue(result)
    }

    fun onIncrementButtonClicked() {
        model.inc()
        val result = model.getResult()
        view?.updateCount(result)
        checkForSpecialValue(result)
    }

    fun detachView() {
        this.view = null
    }

    private fun checkForSpecialValue(value: Int) {
        if (value == 10) {
            view?.showToast("Поздравляем")
        }
        if (value == 15) {
            view?.changeColor(android.graphics.Color.GREEN)
        } else {
            view?.changeColor(android.graphics.Color.BLACK)
        }
    }
}