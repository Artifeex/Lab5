package com.example.lab5.nineth

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab5.R
import com.example.lab5.databinding.BottomSheetLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.lang.RuntimeException


class BottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: BottomSheetLayoutBinding? = null
    private val binding: BottomSheetLayoutBinding
        get() = _binding ?: throw RuntimeException("binding is null!")

    private lateinit var listener: OnClickListener


    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        listener = try {
            activity as OnClickListener
        } catch (e: ClassCastException) {
            throw RuntimeException("Activity must implement OnClickListener")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setButtonsListeners()
    }

    private fun setButtonsListeners() {
        binding.layoutHome.setOnClickListener {
            listener.onCLick("Home")
            dismiss()
        }
        binding.layoutShorts.setOnClickListener {
            listener.onCLick("Shorts")
            dismiss()
        }
        binding.layoutVideo.setOnClickListener {
            listener.onCLick("Video")
            dismiss()
        }
    }

    interface OnClickListener {
        fun onCLick(text: String)
    }

    companion object {
        @JvmStatic
        fun newInstance() = BottomSheetFragment()
    }
}
