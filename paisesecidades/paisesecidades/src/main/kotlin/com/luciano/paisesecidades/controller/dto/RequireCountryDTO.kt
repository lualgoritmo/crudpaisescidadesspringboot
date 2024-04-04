package com.luciano.paisesecidades.controller.dto

import com.luciano.paisesecidades.model.Country
import com.luciano.paisesecidades.util.UniqueValue


data class RequireCountryDTO(
    @field:UniqueValue(
        message = "Esse País já existe!",
        fieldName = "name",
        domainClass = Country::class
    )
    val name: String
) {
    fun toEntity() = Country(idCountry = 0, name = this.name)

    companion object {
        fun fromEntity(country: Country) = RequireCountryDTO(name = country.name)
    }
}