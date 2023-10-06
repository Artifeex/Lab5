package com.example.lab5.fourth

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import com.example.lab4.DatePickerDialog
import com.example.lab5.R
import com.example.lab5.databinding.ActivityFourthBinding
import java.util.Calendar

class FourthActivity : AppCompatActivity(), DatePickerDialog.DatePickerListener {

    private val binding by lazy {
        ActivityFourthBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupDefaultDate()
        binding.bnDatePick.setOnClickListener {
            DatePickerDialog().show(supportFragmentManager, null)
        }
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
        binding.tvDate.text = getString(R.string.date, year, month + 1, day)
    }

    private fun setupDefaultDate() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH) + 1
        val day = c.get(Calendar.DAY_OF_MONTH)

        binding.tvDate.text = getString(R.string.date, year, month, day)
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, FourthActivity::class.java)
    }
}