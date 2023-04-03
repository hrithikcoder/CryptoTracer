package com.example.crptotracker.Fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.crptotracker.R
import com.example.crptotracker.api.ApiInterface
import com.example.crptotracker.api.ApiUtility
import com.example.crptotracker.databinding.ActivityMainBinding
import com.example.crptotracker.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.create

class homefragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(layoutInflater)
        getTopCurrencyList()
        return binding.root
    }
    private fun getTopCurrencyList(){
        lifecycleScope.launch(Dispatchers.IO){
            val res=ApiUtility.getInstance().create(ApiInterface::class.java).getMarketData()
           Log.d("Hrithik","getTopCurrencyList: ${res.body()!!.data.cryptoCurrencyList}")
        }
    }


}