package com.nawin.horoscapp.ui.horoscope.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nawin.horoscapp.R
import com.nawin.horoscapp.domain.model.HoroscopeInfo

class HoroscopeAdapter(
    private var horoscopeList: List<HoroscopeInfo> = emptyList(),
    private val onItemSelected: (HoroscopeInfo) -> Unit) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    fun updateList(list: List<HoroscopeInfo>) {
        horoscopeList = list
        notifyDataSetChanged()

        Log.d("HoroscopeAdapter", "Adapter updated with data: $horoscopeList")

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }

    override fun getItemCount() = horoscopeList.size

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(horoscopeList[position], onItemSelected)
    }

}