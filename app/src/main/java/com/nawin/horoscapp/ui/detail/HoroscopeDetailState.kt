package com.nawin.horoscapp.ui.detail

sealed class HoroscopeDetailState { //--> para gestionar estados de la pantalla: error, loading..etc

    data object Loading:HoroscopeDetailState()
    data class Error(val error:String):HoroscopeDetailState()
    data class Success(val data:String):HoroscopeDetailState()

}