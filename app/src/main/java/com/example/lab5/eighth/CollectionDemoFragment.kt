package com.example.lab5.eighth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.lab5.R

class CollectionDemoFragment: AppCompatActivity() {
    private lateinit var demoCollectionAdapter: DemoCollectionAdapter
    private lateinit var viewPager: ViewPager2



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eighth)
        Log.d("CollectionDemoFragment", "Inside onCreate")

        demoCollectionAdapter = DemoCollectionAdapter(this, createTasks(), createDates())
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = demoCollectionAdapter

    }

    private fun createDates(): List<String> {
        val dates = mutableListOf<String>()
        repeat(7) {
            dates.add("0${it +1}.10.2023")
        }
        return dates
    }

    private fun createTasks(): List<List<String>> {
        val tasks = mutableListOf<List<String>>()
        repeat(7) {
            tasks.add(listOf("анжумания", "прэсс", "бегит"))
        }
        return tasks
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, CollectionDemoFragment::class.java)
    }

}

class DemoCollectionAdapter(
    fragment: FragmentActivity,
    private val listTasks: List<List<String>>,
    private val listDates: List<String>
): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return listTasks.size
    }

    override fun createFragment(position: Int): Fragment {
        return DemoObjectFragment().apply {
            arguments = Bundle().apply {
                putStringArray(DemoObjectFragment.LIST_TASKS, listTasks[position].toTypedArray())
                putString(DemoObjectFragment.DATE, listDates[position])
        }
    }
}

class DemoObjectFragment: Fragment() {

    private lateinit var tasks: Array<String>
    private lateinit var date: String

    companion object {
        const val LIST_TASKS = "listTasks"
        const val DATE = "date"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        parseArguments()
        return inflater.inflate(R.layout.task_description_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val ll = view.findViewById<LinearLayout>(R.id.llTasksList)
        val tvDate = view.findViewById<TextView>(R.id.tvDate)
        tvDate.text = date
        for(task in tasks) {
            val textView = TextView(context).apply {
                text = task
                textSize = 20.0f
                setTextColor(context.getColor(R.color.black))
            }
            ll.addView(textView)
        }

    }

    private fun parseArguments() {
        date = requireArguments().getString(DATE)!!
        tasks = requireArguments().getStringArray(LIST_TASKS)!!
    }
}
}