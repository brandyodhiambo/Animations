package com.adhanjas.animations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adhanjas.animations.databinding.CountryRowBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder

class CountryRecyclerAdapter :ListAdapter<CountryModel.CountryModelItem,CountryRecyclerAdapter.CountryViewHolder>(MyDiffutill){
    inner class CountryViewHolder(private val binding: CountryRowBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: CountryModel.CountryModelItem?) {
            binding.countryTitle.text=item?.name
            binding.countryDescription.text=item?.capital
            Glide.with(binding.countryImage)
                    .load("https://cdn.britannica.com/15/15-004-B5D6BF80/Flag-Kenya.jpg")
                    .into(binding.countryImage)

        }

    }
    object  MyDiffutill:DiffUtil.ItemCallback<CountryModel.CountryModelItem>() {
        override fun areItemsTheSame(oldItem: CountryModel.CountryModelItem, newItem: CountryModel.CountryModelItem): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: CountryModel.CountryModelItem, newItem: CountryModel.CountryModelItem): Boolean {
           return oldItem.capital==newItem.capital
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(CountryRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
       val item=getItem(position)
        holder.bind(item)
    }
}