package com.paulinoeme.proyecto.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.paulinoeme.proyecto.R
import com.paulinoeme.proyecto.data.Provider
import com.paulinoeme.proyecto.databinding.FragmentInstrumentsBinding

class InstrumentsFragment : Fragment() {
    private var _binding: FragmentInstrumentsBinding? = null
    private val binding get() = _binding!!
    private var mediaPlayer: MediaPlayer? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mediaPlay(R.raw.instrumentos)

        //Refactorización de Código

        binding.btnAcordeon.setOnClickListener {
            instrument(0)
        }

        binding.btnArpa.setOnClickListener {
            instrument(1)

        }

        binding.btnGuitarra.setOnClickListener {
            instrument(2)
        }

        binding.btnMaracas.setOnClickListener {
            instrument(3)
        }

        binding.btnPanderete.setOnClickListener {
            instrument(4)
        }

        binding.btnPiano.setOnClickListener {
            instrument(5)
        }

        binding.btnTrompeta.setOnClickListener {
            instrument(6)
        }

        binding.btnViolin.setOnClickListener {
            instrument(7)
        }

        binding.btnXilofono.setOnClickListener {
            instrument(8)
        }

        binding.btnGame.setOnClickListener {
            mediaPlayer?.stop()
            findNavController().navigate(R.id.action_instrumentsFragment_to_gameFragment)
        }

        binding.btnRandom.setOnClickListener {
            findNavController().navigate(R.id.action_instrumentsFragment_to_randomFragment)
        }
    }

    private fun instrument(num: Int){
        Toast.makeText(context, Provider.instruments[num].name, Toast.LENGTH_LONG).show()
        binding.tvInstruments.text = Provider.instruments[num].name
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
        _binding = FragmentInstrumentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = InstrumentsFragment().apply {}
    }
}