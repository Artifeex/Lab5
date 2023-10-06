package com.example.lab5.sixth

import android.animation.LayoutTransition
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.lab5.R

class SixthActivity : AppCompatActivity() {

    private lateinit var llTasks: LinearLayout
    private lateinit var llCardView: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sixth)
        llTasks = findViewById(R.id.llTasks)
        setTasks()

    }

    private fun setTasks() {
        repeat(5) {
            val view = layoutInflater.inflate(R.layout.task_list_item, llTasks, false)
            llCardView = view.findViewById<LinearLayout>(R.id.llCardView)
            llCardView.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
            val title = view.findViewById<TextView>(R.id.tvCardViewTitle)
            title.text = "0${it+1}.10.2023"
            val description = view.findViewById<TextView>(R.id.llCardViewDesc)
            description.text = "Анжумания\nпрэсс\nбегит\n"
            TransitionManager.beginDelayedTransition(llCardView, AutoTransition())
            view.setOnClickListener {
                if(description.isVisible) {
                    description.visibility = View.GONE
                } else {
                    description.visibility = View.VISIBLE
                }
            }
            llTasks.addView(view)
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, SixthActivity::class.java)
    }
}