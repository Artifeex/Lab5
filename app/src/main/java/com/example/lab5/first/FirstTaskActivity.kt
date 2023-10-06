package com.example.lab5.first

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab5.R

class FirstTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_task)
        if(savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, FirstTaskFragment())
                .addToBackStack(null)
                .commit()
        }

    }

    companion object {
        fun newIntent(context: Context) = Intent(context, FirstTaskActivity::class.java)
    }


}