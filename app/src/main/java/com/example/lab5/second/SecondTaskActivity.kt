package com.example.lab5.second

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab5.R

class SecondTaskActivity : AppCompatActivity() {

    override fun onBackPressed() {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_task)
        supportFragmentManager.beginTransaction()
            .add(R.id.fcTop, SecondTaskFragmentTop())
            .addToBackStack("FirstFragment")
            .commit()
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, SecondTaskActivity::class.java)
    }
}