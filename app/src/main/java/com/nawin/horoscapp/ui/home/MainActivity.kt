package com.nawin.horoscapp.ui.home

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nawin.horoscapp.R
import com.nawin.horoscapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /*Inicializar el binding*/
    private lateinit var  binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*Configurar el Binding*/
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}