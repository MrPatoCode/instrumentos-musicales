package com.paulinoeme.proyecto.data

import com.paulinoeme.proyecto.R

object Provider {
    val instruments = mutableListOf(
        Instrument(
            name = "Acordeón",
            image = R.mipmap.acordeon,
            sound = R.raw.acordeon
        ),

        Instrument(
            name = "Arpa",
            image = R.mipmap.arpa,
            sound = R.raw.arpa
        ),

        Instrument(
            name = "Guitarra",
            image = R.mipmap.guitarra,
            sound = R.raw.guitarra
        ),

        Instrument(
            name = "Maracas",
            image = R.mipmap.maracas,
            sound = R.raw.maracas
        ),

        Instrument(
            name = "Panderete",
            image = R.mipmap.pandereta,
            sound = R.raw.panderete
        ),

        Instrument(
            name = "Piano",
            image = R.mipmap.teclado,
            sound = R.raw.piano
        ),

        Instrument(
            name = "Trompeta",
            image = R.mipmap.trompeta,
            sound = R.raw.trompeta
        ),

        Instrument(
            name = "Violín",
            image = R.mipmap.otorgar,
            sound = R.raw.violin
        ),

        Instrument(
            name = "Xilófono",
            image = R.mipmap.xilofono,
            sound = R.raw.xilofono
        ),

    )
}