package com.paulinoeme.proyecto.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.paulinoeme.proyecto.R
import com.paulinoeme.proyecto.data.Provider
import com.paulinoeme.proyecto.databinding.FragmentGameBinding
import com.paulinoeme.proyecto.dialog.DialogAbout
import com.paulinoeme.proyecto.dialog.DialogExitGame

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private var question = 1
    private var num = 0
    private var mediaPlayer: MediaPlayer? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        levels()

        binding.btnYes.setOnClickListener {
            answerYes()
        }

        binding.btnNo.setOnClickListener {
            answerNo()
        }

        binding.btnArrow.setOnClickListener {
            levels()
            binding.tvInstrument.text = "Instrumento"
        }

        binding.ivInstrument.setOnClickListener {
            levels()
            binding.tvInstrument.text = "Instrumento"
        }

    }

    private fun answerYes(){
        mediaPlayer?.stop()
        if (1 == question || 3 == question || 4 == question){
            binding.tvInstrument.text = "Correcto"
            mediaPlay(R.raw.correct)
            num++
        }
        else{
            binding.tvInstrument.text = "Incorrecto"
            mediaPlay(R.raw.wrong)
        }

        question++
        visible(false)
    }

    private fun answerNo(){
        mediaPlayer?.stop()
        if (2 == question || 5 == question){
            binding.tvInstrument.text = "Correcto"
            mediaPlay(R.raw.correct)
            num++
        }
        else{
            binding.tvInstrument.text = "Incorrecto"
            mediaPlay(R.raw.wrong)
        }

        question++
        visible(false)
    }

    fun levels(){
        when(question){
           1 -> {
               binding.ivInstrument.setImageResource(Provider.instruments[6].image)
               mediaPlay(Provider.instruments[6].sound, R.raw.pregunta, true)
           }

           2 ->{
               binding.ivInstrument.setImageResource(Provider.instruments[5].image)
               mediaPlay(Provider.instruments[0].sound, R.raw.pregunta, true)
           }

           3 ->{
               binding.ivInstrument.setImageResource(Provider.instruments[4].image)
               mediaPlay(Provider.instruments[4].sound, R.raw.pregunta, true)
           }

           4 ->{
               binding.ivInstrument.setImageResource(Provider.instruments[8].image)
               mediaPlay(Provider.instruments[8].sound, R.raw.pregunta, true)
           }

           5 ->{
               binding.ivInstrument.setImageResource(Provider.instruments[7].image)
               mediaPlay(Provider.instruments[2].sound, R.raw.pregunta, true)
           }

           6->{
                dialog()
           }
        }


        visible(true)
    }

    private fun mediaPlay(audio: Int, audio2: Int = R.raw.pregunta, next: Boolean = false){
        mediaPlayer?.stop()
        mediaPlayer = MediaPlayer.create(context, audio)
        mediaPlayer?.start()
        mediaPlayer?.setVolume(1.0f, 1.0f)

        if(next)
            mediaPlayer?.setOnCompletionListener {
                mediaNext(audio2)
            }

    }

    private fun mediaNext(audio2: Int) {
        mediaPlayer?.reset()
        mediaPlayer = MediaPlayer.create(context, R.raw.pregunta)
        mediaPlayer?.start()
        mediaPlayer?.setVolume(1.0f, 1.0f)
    }

    fun visible(switch: Boolean){
        binding.btnNo.isVisible = switch
        binding.btnYes.isVisible = switch

        if (!switch){
            binding.btnArrow.isVisible = true
            return
        }
        binding.btnArrow.isVisible = false

    }

    private fun dialog(){
        var dialog = DialogExitGame()
        dialog.showsDialog(
            onClosed ={it.dismiss()},
            fragmentManager = parentFragmentManager,
            num
        )
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
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = GameFragment().apply {}
    }
}