package com.example.lab5.nineth


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import com.example.lab5.R
import com.example.lab5.databinding.ActivityNinethBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class NinethActivity : AppCompatActivity(), BottomSheetFragment.OnClickListener {

    private lateinit var detector: GestureDetectorCompat

    private val binding by lazy {
        ActivityNinethBinding.inflate(layoutInflater)
    }

    override fun onCLick(text: String) {
        binding.tvChosenAction.text = text
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return if(event == null) {
            super.onTouchEvent(event)
        } else {
            if(detector.onTouchEvent(event)) {
                true
            } else {
                super.onTouchEvent(event)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        detector = GestureDetectorCompat(this, DiaryGestureListener())
        binding.fab.setOnClickListener {
            BottomSheetFragment().show(supportFragmentManager, null)
        }
        if(savedInstanceState == null) {
            updateText(binding.bottomNavigationView.selectedItemId)
        }
        binding.bottomNavigationView.setOnItemSelectedListener {
            updateText(it.itemId)
            return@setOnItemSelectedListener true
        }
    }

    private fun updateText(itemId: Int) {
        when(itemId) {
            R.id.menuHome -> binding.tvChosenAction.text = "Home"
            R.id.menuLibrary -> binding.tvChosenAction.text = "Library"
            R.id.menuShorts -> binding.tvChosenAction.text = "Shorts"
            R.id.menuSubs -> binding.tvChosenAction.text = "Subs"
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, NinethActivity::class.java)
    }

    inner class DiaryGestureListener : GestureDetector.SimpleOnGestureListener() {

        private val SWIPE_THRESHOLD = 100
        private val SWIPE_VELOCITY = 100


        override fun onFling(
            downEvent: MotionEvent, //грубо говоря координаты того, когда пользователь нажал на экран
            moveEvent: MotionEvent, //когда отпустил
            velocityX: Float,
            velocityY: Float
        ): Boolean {

            var diffX = moveEvent?.x?.minus(downEvent!!.x) ?: 0.0F
            var diffY = moveEvent?.y?.minus(downEvent!!.y) ?: 0.0F

            if(Math.abs(diffX) < Math.abs(diffY)) {
                //Y swipe
                if(Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY ) {
                    //Свайп снизу вверх(Y координата растет от начала экрана в сторону низа)
                    if(diffY < 0) {
                        this@NinethActivity.onSwipeUp()
                    }
                }
            } else {
                //X swipe
            }
            return super.onFling(downEvent, moveEvent, velocityX, velocityY)
        }
    }

    private fun onSwipeUp() {
        BottomSheetFragment().show(supportFragmentManager, null)
    }


}