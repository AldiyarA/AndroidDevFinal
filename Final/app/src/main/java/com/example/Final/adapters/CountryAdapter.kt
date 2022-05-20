package com.example.Final.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.Final.R
import com.example.Final.models.Country

class CountryAdapter(
    private val clickHandler: (Country) -> Unit
): ListAdapter<Country, CountryAdapter.ViewHolder>(DIFF_CONFIG){

    companion object {
        val DIFF_CONFIG = object : DiffUtil.ItemCallback<Country>() {
            override fun areContentsTheSame(
                oldItem: Country,
                newItem: Country
            ): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
                return oldItem === newItem
            }
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var country: TextView = itemView.findViewById(R.id.country)
        var slug: TextView = itemView.findViewById(R.id.slug)
        var ISO2: TextView = itemView.findViewById(R.id.ISO2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.country_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {
        val country = getItem(position)
        holder.country.text = country.country
        holder.slug.text = country.slug
        holder.ISO2.text = country.ISO2

        holder.itemView.setOnClickListener {
            clickHandler(country)
        }
    }
}