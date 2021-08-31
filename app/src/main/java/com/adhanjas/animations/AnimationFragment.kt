package com.adhanjas.animations

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.adhanjas.animations.databinding.FragmentAnimationBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimationFragment : Fragment() {
    private lateinit var binding: FragmentAnimationBinding
    private val adapter by lazy { RecyclerAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAnimationBinding.inflate(inflater,container,false)
        val view=binding.root

        AnimationsApi.apiService1.getAnimations().enqueue(object : Callback<AnimationModel>{
            override fun onFailure(call: Call<AnimationModel>, t: Throwable) {
                Toast.makeText(activity?.applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                binding.animationsProgressbar.isVisible=false
                binding.failedTextView.isVisible=true
            }

            override fun onResponse(call: Call<AnimationModel>, response: Response<AnimationModel>) {
              val animationList=response.body()?.results
                adapter.submitList(animationList)
                binding.animationRecyclerView.adapter=adapter
                binding.animationsProgressbar.isVisible=false
            }

        })

        return view
    }


}