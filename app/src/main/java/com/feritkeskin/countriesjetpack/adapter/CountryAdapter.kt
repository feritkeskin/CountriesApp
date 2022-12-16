package com.feritkeskin.countriesjetpack.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.feritkeskin.countriesjetpack.R
import com.feritkeskin.countriesjetpack.model.Country
import com.feritkeskin.countriesjetpack.util.downloadFromUrl
import com.feritkeskin.countriesjetpack.util.placeHolderProgressBar
import com.feritkeskin.countriesjetpack.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryList: ArrayList<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.view.name.text = countryList[position].countryName
        holder.view.region.text = countryList[position].countryRegion

        holder.view.setOnClickListener {
            //val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            //Navigation.findNavController(it).navigate(action)
        }

        countryList[position].imageUrl?.let {
            holder.view.imageView.downloadFromUrl(it, placeHolderProgressBar(holder.view.context))
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateCountryList(newCountryList: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }
}