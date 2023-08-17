package com.menesdurak.rickandmorty.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.menesdurak.rickandmorty.data.dto.Result
import com.menesdurak.rickandmorty.databinding.ItemLocationBinding

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.LocationHolder>() {

    private val items = mutableListOf<Result>()

    inner class LocationHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(locationResult: Result) {
            binding.tvLocationId.text = locationResult.id.toString()
            binding.tvLocationName.text = locationResult.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationHolder {
        val bind = ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationHolder(bind)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: LocationHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateList(newList: List<Result>) {
        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }
}