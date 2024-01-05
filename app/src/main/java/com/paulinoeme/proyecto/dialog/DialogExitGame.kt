package com.paulinoeme.proyecto.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.paulinoeme.proyecto.R

import com.paulinoeme.proyecto.databinding.DialogExitGameBinding

class DialogExitGame: DialogFragment() {
    private lateinit var binding: DialogExitGameBinding
    private var onClosed : (DialogFragment) -> Unit ={}
    private var num: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogExitGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isCancelable = false
        binding.btnClose.setOnClickListener {
            dismiss()
            findNavController().navigate(R.id.action_gameFragment_to_menuFragment)
        }

        binding.TVnumber.text = num.toString()
    }

    fun showsDialog(
        onClosed: (dialog: DialogFragment) -> Unit,
        fragmentManager: FragmentManager, num: Int
    ){
        this.onClosed = onClosed
        this.show(fragmentManager, this::class.java.simpleName)
        this.num = num
    }

}