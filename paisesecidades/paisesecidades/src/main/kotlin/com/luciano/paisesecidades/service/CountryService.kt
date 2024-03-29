package com.luciano.paisesecidades.service

import com.luciano.paisesecidades.controller.dto.ResponseCountryWithStatesDTO
import com.luciano.paisesecidades.model.Country

interface CountryService {
    fun createCountrie(countries: Country): Country
    fun getAllCountries(): List<Country>
    fun getWithIdCountry(idCountry: Long): Country
    fun getAllCountriesWithStates(): List<ResponseCountryWithStatesDTO>
    fun updateWithIdCountry(idCountry: Long, updateCountry: Country): Country
    fun deleteWithIdContry(idCountry: Long)
}