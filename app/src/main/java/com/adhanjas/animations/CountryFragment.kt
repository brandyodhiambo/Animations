package com.adhanjas.animations

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.adhanjas.animations.databinding.CountryRowBinding
import com.adhanjas.animations.databinding.FragmentCountryBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CountryFragment : Fragment() {
    private lateinit var binding: FragmentCountryBinding
    private val adapter2 by lazy { CountryRecyclerAdapter()}
    private val TAG = "CountryFragment"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCountryBinding.inflate(inflater,container,false)
        
        val view=binding.root
        AnimationsApi.apiService2.getCountries().enqueue(object:Callback<CountryModel>{
            override fun onFailure(call: Call<CountryModel>, t: Throwable) {
                Toast.makeText(activity?.applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                binding.countryprogressBar.isVisible=false
                binding.countrytextView.isVisible=true
            }

            override fun onResponse(call: Call<CountryModel>, response: Response<CountryModel>) {
                val countryList=response.body()
                adapter2.submitList(countryList)
                //Log.d(TAG, "onResponse: ${countryList?.get(0)?.capital}")
                binding.countryRecyclerView.adapter=adapter2
                binding.countryprogressBar.isVisible=false
            }

        })
        
        
        return view
        
    }


}