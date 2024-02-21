package com.nawin.horoscapp.data.providers

import com.nawin.horoscapp.domain.model.HoroscopeInfo
import com.nawin.horoscapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() { //convertimos la clase con @inyect constructor para que lo reciva HoroscopeViewModel con dagger hilt

    fun getHoroscopes():List<HoroscopeInfo>{

        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}