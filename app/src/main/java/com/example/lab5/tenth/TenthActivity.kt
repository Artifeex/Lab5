package com.example.lab5.tenth

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.lab5.R

class TenthActivity : AppCompatActivity() {

    private lateinit var linearLayout: LinearLayout
    private lateinit var textView: TextView
    private var curTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tenth)
        linearLayout = findViewById(R.id.linearLayout)
        textView = findViewById(R.id.tvText)
        initLinearLayout()
    }

    private fun initLinearLayout() {
        repeat(4) {
            val view = layoutInflater.inflate(R.layout.list_element_view, linearLayout, false)
            val tv = view.findViewById<TextView>(R.id.tvElement)
            tv.text = "Element ${it + 1}"
            registerForContextMenu(view)
            linearLayout.addView(view)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        //v - view, по которой долго нажали и она вызвала contextMenu
        super.onCreateContextMenu(menu, v, menuInfo)
        curTextView = v?.findViewById(R.id.tvElement)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        //val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return when (item.itemId) {
            R.id.editMenuItem -> {
                textView?.text = "${curTextView?.text} with position = 3"
                true
            }

            R.id.homeMenuItem -> {
                textView?.text = "${curTextView?.text}  with position = 1"
                true
            }

            R.id.personMenuItem -> {
                textView?.text = "${curTextView?.text}  with position = 2"
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }



    companion object {
        fun newIntent(context: Context) = Intent(context, TenthActivity::class.java)
    }
}