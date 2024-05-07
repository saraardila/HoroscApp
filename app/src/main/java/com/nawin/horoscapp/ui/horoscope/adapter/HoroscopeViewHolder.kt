package com.nawin.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.nawin.horoscapp.databinding.ItemHoroscopeBinding
import com.nawin.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit){
        val context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
       binding.tvTitle.text = context.getString(horoscopeInfo.name)

        binding.parent.setOnClickListener{//cuando pulsamos seleccionamos un iteem
        startRotationAnimation(binding.ivHoroscope, newLambda ={onItemSelected(horoscopeInfo)})
       //     onItemSelected(horoscopeInfo)

        }
    }

   private fun startRotationAnimation(view:View, newLambda:()->Unit){ //ANIMACION WII

        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator() //el camino de la animacion
            rotationBy(360f) //rotacion sobre si mismo de 360º
            withEndAction{newLambda()} // esto se va a ejecutar cuando termine la animacion
            start()
        }
    }
}