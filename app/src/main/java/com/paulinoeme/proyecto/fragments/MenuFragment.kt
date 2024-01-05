package com.paulinoeme.proyecto.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.paulinoeme.proyecto.R
import com.paulinoeme.proyecto.databinding.FragmentMenuBinding
import com.paulinoeme.proyecto.dialog.DialogAbout

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEntr.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_instrumentsFragment)
        }

        binding.btnAbout.setOnClickListener {
            dialog()
        }
    }

    private fun dialog(){
        var dialog = DialogAbout()
        dialog.showsDialog(
            onClosed ={it.dismiss()},
            fragmentManager = parentFragmentManager,
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = MenuFragment().apply {}
    }
}