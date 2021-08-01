package com.adhanjas.animations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.adhanjas.animations.databinding.CountryRowBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CountryFragment : Fragment() {
    private lateinit var binding: CountryRowBinding
    private val adapter2 by lazy { CountryRecyclerAdapter()}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= CountryRowBinding.inflate(inflater,container,false)
        
        val view=binding.root
        AnimationsApi.apiService2.getCountries().enqueue(object:Callback<CountryModel>{
            override fun onFailure(call: Call<CountryModel>, t: Throwable) {
                Toast.makeText(activity?.applicationContext, "Failed", Toast.LENGTH_SHORT).show() 
            }

            override fun onResponse(call: Call<CountryModel>, response: Response<CountryModel>) {
                val countryList=response.body().
                adapter2.submitList(countryList)
            }

        })
        
        
        return view
        
    }


}