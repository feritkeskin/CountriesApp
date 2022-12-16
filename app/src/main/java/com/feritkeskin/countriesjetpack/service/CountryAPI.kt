package com.feritkeskin.countriesjetpack.service

import com.feritkeskin.countriesjetpack.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {

    @GET("https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")

    fun getCountries(): Single<List<Country>>
}