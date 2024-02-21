package com.nawin.horoscapp.ui.horoscope

import android.util.Log
import androidx.lifecycle.ViewModel
import com.nawin.horoscapp.data.providers.HoroscopeProvider
import com.nawin.horoscapp.domain.model.HoroscopeInfo
import com.nawin.horoscapp.domain.model.HoroscopeInfo.* //con el .* se importa la clase y no hace falta llamarla.
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider):ViewModel() { //llamamos al provider con dagger hilt

    private var _horoscope =
        MutableStateFlow<List<HoroscopeInfo>>(emptyList()) //Comunicacion de estados entre los datos y la vista, va mandando la info segun la tiene disponible

    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope // el primero es mutable, la podemos modificar nosotros, pero el segundo no para que desde fuera no se pueda, por eso lo metemos ahi

    init { //cuando _horoscope se crea, empieza con la lista vacia pero llama a esto.
        _horoscope.value = horoscopeProvider.getHoroscopes()
    }

}