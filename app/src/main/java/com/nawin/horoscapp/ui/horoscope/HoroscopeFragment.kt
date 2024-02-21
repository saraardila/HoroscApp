package com.nawin.horoscapp.ui.horoscope

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.nawin.horoscapp.databinding.FragmentHoroscopeBinding
import com.nawin.horoscapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    /* llamar al hiltViewModel para que conecte con el fragmen */
    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()

    private lateinit var horoscopeAdapter:HoroscopeAdapter

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        initList()
        initUiState()
    }

    private fun initList() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
            Toast.makeText(context,getString(it.name),Toast.LENGTH_LONG).show()})
        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context,2) //para el numero de filas de los iconos del horoscopo
            adapter = horoscopeAdapter
        }

    }


    private fun initUiState() {
        lifecycleScope.launch { //Corrutina
            repeatOnLifecycle(Lifecycle.State.STARTED){//cuando empiece el ciclo de vida llamamos a la coleccion de horoscopo
                horoscopeViewModel.horoscope.collect(){
                    //cuando entra aqui es que ha habido cambios
                    horoscopeAdapter.updateList(it)

                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root

    }
}