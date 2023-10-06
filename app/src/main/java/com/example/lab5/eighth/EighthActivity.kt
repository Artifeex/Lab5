package com.example.lab5.eighth

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab5.R

class EighthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eighth)
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, EighthActivity::class.java)
    }
}