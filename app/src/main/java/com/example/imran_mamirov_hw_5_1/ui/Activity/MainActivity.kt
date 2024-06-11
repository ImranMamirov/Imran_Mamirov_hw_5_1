package com.example.imran_mamirov_hw_5_1.ui.Activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imran_mamirov_hw_5_1.databinding.ActivityMainBinding
import com.example.imran_mamirov_hw_5_1.ui.Interface.CounterView
import com.example.imran_mamirov_hw_5_1.ui.Presenter

class MainActivity : AppCompatActivity(), CounterView {

    private val presenter = Presenter()
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter.attachView(this)

        with(binding) {
            btnInc.setOnClickListener {
                presenter.onIncrementButtonClicked()
            }

            btnDec.setOnClickListener {
                presenter.onDecrementButtonClicked()
            }
        }
    }

    override fun updateCount(count: Int) {
        binding.tvCounterResult.text = count.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeColor(color: Int) {
        binding.tvCounterResult.setTextColor(color)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}