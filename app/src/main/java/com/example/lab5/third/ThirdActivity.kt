package com.example.lab5.third

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.lab5.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity(), EditTextDialog.DialogListener {


    override fun onDialogPositiveClick(text: String) {
        binding.tvInputText.text = text
    }

    private val binding by lazy {
        ActivityThirdBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.bnInputText.setOnClickListener {
            EditTextDialog().show(supportFragmentManager, null)
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, ThirdActivity::class.java)
    }
}