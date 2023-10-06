package com.example.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab5.databinding.ActivityMainBinding
import com.example.lab5.eighth.CollectionDemoFragment
import com.example.lab5.eighth.EighthActivity
import com.example.lab5.fifth.FifthActivity
import com.example.lab5.first.FirstTaskActivity
import com.example.lab5.fourth.FourthActivity
import com.example.lab5.nineth.NinethActivity
import com.example.lab5.second.SecondTaskActivity
import com.example.lab5.seventh.SeventhActivity
import com.example.lab5.sixth.SixthActivity
import com.example.lab5.tenth.TenthActivity
import com.example.lab5.third.ThirdActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListenersToButtons()
    }

    private fun setListenersToButtons() {
        binding.bnTask1.setOnClickListener {
            startActivity(FirstTaskActivity.newIntent(this))
        }
        binding.bnTask2.setOnClickListener {
            startActivity(SecondTaskActivity.newIntent(this))
        }
        binding.bnTask3.setOnClickListener {
            startActivity(ThirdActivity.newIntent(this))
        }
        binding.bnTask4.setOnClickListener {
            startActivity(FourthActivity.newIntent(this))
        }
        binding.bnTask5.setOnClickListener {
            startActivity(FifthActivity.newIntent(this))
        }
        binding.bnTask6.setOnClickListener {
            startActivity(SixthActivity.newIntent(this))
        }
        binding.bnTask7.setOnClickListener {
            startActivity(SeventhActivity.newIntent(this))
        }
        binding.bnTask8.setOnClickListener {
            startActivity(CollectionDemoFragment.newIntent(this))
        }
        binding.bnTask9.setOnClickListener {
            startActivity(NinethActivity.newIntent(this))
        }
        binding.bnTask10.setOnClickListener {
            startActivity(TenthActivity.newIntent(this))
        }
    }
}