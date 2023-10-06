package com.example.lab5.fifth

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import com.example.lab5.R
import com.example.lab5.databinding.ActivityFifthBinding
import java.util.Calendar

class FifthActivity : AppCompatActivity(), TimePickerFragment.TimePickerListener {
    private val binding by lazy {
        ActivityFifthBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupDefaultTime()
        binding.bnTimePick.setOnClickListener {
            TimePickerFragment().show(supportFragmentManager, null)
        }
    }

    private fun setupDefaultTime() {
        val calendar = Calendar.getInstance()
        val hours = calendar.get(Calendar.HOUR_OF_DAY)
        val minutes = calendar.get(Calendar.MINUTE)
        binding.tvTime.text = getString(R.string.time, hours, minutes)
    }

    override fun onTimeSet(p0: TimePicker?, hours: Int, minutes: Int) {
        binding.tvTime.text = getString(R.string.time, hours, minutes)
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, FifthActivity::class.java)
    }
}