package com.luciano.paisesecidades.controller.dto

import com.luciano.paisesecidades.model.Country
import com.luciano.paisesecidades.model.StateUSA
import com.luciano.paisesecidades.util.UniqueValue

data class CreateStateDTO(
    @field:UniqueValue(
        message = "Esse Estadi já existe!",
        fieldName = "name",
        domainClass = StateUSA::class
    )
    val name: String, val countryId: Long
) {
    fun toEntity() = StateUSA(idState = 0, name = this.name, countryId = Country(idCountry = this.countryId, name = ""))

    companion object {
        fun fromEntity(state: StateUSA) = CreateStateDTO(name = state.name, countryId = state.countryId.idCountry)
    }
}
