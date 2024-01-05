package com.paulinoeme.proyecto.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.paulinoeme.proyecto.data.Provider
import com.paulinoeme.proyecto.databinding.FragmentRandomBinding

class RandomFragment : Fragment() {
    private var _binding: FragmentRandomBinding? = null
    private val binding get() = _binding!!
    private var mediaPlayer: MediaPlayer? = null
    private var num = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showInstrument()

        //Eliminación de botones derecha e izquierda. Se agregó el boton random

        binding.btnRandom.setOnClickListener {
            showInstrument()
        }
    }

    private fun showInstrument(){
        num = (0..8).random()
        binding.tvInstrument.text = Provider.instruments[num].name
        binding.ivInstrument.setImageResource(Provider.instruments[num].image)
        mediaPlay(Provider.instruments[num].sound)
    }

    private fun mediaPlay(audio: Int){
        mediaPlayer?.stop()
        mediaPlayer = MediaPlayer.create(context, audio)
        mediaPlayer?.setVolume(1.0f, 1.0f)
        mediaPlayer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandomBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RandomFragment().apply {
            }
    }
}