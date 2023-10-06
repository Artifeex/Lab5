package com.example.lab5.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab5.R
import com.example.lab5.databinding.FragmentFirstTaskBinding

class FirstTaskFragment: Fragment() {

    private var _binding: FragmentFirstTaskBinding? = null
    private val binding: FragmentFirstTaskBinding
        get() = _binding ?: throw IllegalStateException("FragmentFirstTaskBinding is equal to null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.bnBack.setOnClickListener {
            if(parentFragmentManager.backStackEntryCount == 1) {
                requireActivity().finish()
            } else {
                parentFragmentManager.popBackStack()
            }
        }
        binding.bnForward.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, FirstTaskFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.tvStackSize.text = getString(R.string.stack_size, parentFragmentManager.backStackEntryCount)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}