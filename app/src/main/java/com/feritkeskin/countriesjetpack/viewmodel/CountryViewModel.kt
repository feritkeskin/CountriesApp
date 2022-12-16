package com.feritkeskin.countriesjetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.feritkeskin.countriesjetpack.model.Country

class CountryViewModel : ViewModel() {

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom() {
        val country = Country("Turkey", "Asia", "Ankara", "TRY", "Turkish", "www.kotlin.com")
        countryLiveData.value = country
    }
}