package com.paulinoeme.proyecto.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

import com.paulinoeme.proyecto.databinding.DialogAboutBinding

class DialogAbout: DialogFragment() {

    private lateinit var binding: DialogAboutBinding
    private var onClosed : (DialogFragment) -> Unit ={}
    private var num: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCancelable = false


        binding.btnClose.setOnClickListener {dismiss() }
    }

    fun showsDialog(
        onClosed: (dialog: DialogFragment) -> Unit,
        fragmentManager: FragmentManager
    ){
        this.onClosed = onClosed
        this.show(fragmentManager, this::class.java.simpleName)
    }
}