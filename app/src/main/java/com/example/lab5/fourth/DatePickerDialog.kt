package com.example.lab4

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DatePickerDialog: DialogFragment() {

    private lateinit var listener: DatePickerListener

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        try {
            listener =  activity as DatePickerListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$activity must implement DatePickerListener")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        return DatePickerDialog(requireContext(), listener, year, month, day)
    }

    interface DatePickerListener: DatePickerDialog.OnDateSetListener
}