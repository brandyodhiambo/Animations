package com.adhanjas.animations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adhanjas.animations.databinding.AnimationsRowBinding
import com.bumptech.glide.Glide

class RecyclerAdapter : ListAdapter<AnimationModel.Result, RecyclerAdapter.MyViewHolder>(MyDiffutil) {
    inner class MyViewHolder(private val binding: AnimationsRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AnimationModel.Result?) {
            binding.animationTitle.text = item?.title
            binding.animationDescription.text = item?.synopsis
            Glide.with(binding.animationImage)
                    .load(item?.imageUrl)
                    .into(binding.animationImage)
        }
    }

    object MyDiffutil : DiffUtil.ItemCallback<AnimationModel.Result>() {
        override fun areItemsTheSame(oldItem: AnimationModel.Result, newItem: AnimationModel.Result): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: AnimationModel.Result, newItem: AnimationModel.Result): Boolean {
            return oldItem.synopsis == newItem.synopsis
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(AnimationsRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}