package com.example.lab5.third

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.lab5.databinding.FragmentThirdTaskBinding

class EditTextDialog : DialogFragment() {

    private lateinit var listener: DialogListener

    private val binding by lazy {
        FragmentThirdTaskBinding.inflate(layoutInflater)
    }

    interface DialogListener {
        fun onDialogPositiveClick(text: String)
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        try {
            listener = activity as DialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException("${activity.toString()} must implement DialogListener")
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setView(binding.root)
            builder.setTitle("Input text")
            builder.setPositiveButton(
                "Add",
                DialogInterface.OnClickListener { _, _ ->
                    listener.onDialogPositiveClick(binding.etInputText.text.toString())
                })
            builder.setNegativeButton(
                "Cancel",
                DialogInterface.OnClickListener { _, _ -> }
            )
            builder.create()

        } ?: throw RuntimeException("Activity cant be null")
    }
}

