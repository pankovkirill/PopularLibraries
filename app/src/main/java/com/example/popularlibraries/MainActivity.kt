package com.example.popularlibraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.example.popularlibraries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCounter1.setOnClickListener {
            presenter.counterClick(0)
        }
        binding.btnCounter2.setOnClickListener {
            presenter.counterClick(1)
        }
        binding.btnCounter3.setOnClickListener {
            presenter.counterClick(2)
        }
    }

    override fun setFirstButtonText(text: String) {
        binding.btnCounter1.text = text
    }

    override fun setSecondButtonText(text: String) {
        binding.btnCounter2.text = text
    }

    override fun setThirdButtonText(text: String) {
        binding.btnCounter3.text = text
    }


}