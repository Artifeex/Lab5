package com.example.lab5.fifth

import android.app.Activity
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment

import java.util.Calendar

class TimePickerFragment: DialogFragment() {

    private lateinit var listener: TimePickerListener

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        try {
            listener =  activity as TimePickerListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$activity must implement TimePickerListener")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minutes = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(activity, listener, hour, minutes, true)
    }

    interface TimePickerListener: TimePickerDialog.OnTimeSetListener
}