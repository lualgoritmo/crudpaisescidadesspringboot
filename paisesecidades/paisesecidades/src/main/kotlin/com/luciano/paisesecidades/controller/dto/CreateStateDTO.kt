package com.luciano.paisesecidades.controller.dto

import com.luciano.paisesecidades.model.Country
import com.luciano.paisesecidades.model.StateUSA

data class CreateStateDTO(val name: String, val countryId: Long) {
    fun toEntity() = StateUSA(idState = 0, name = this.name, countryId = Country(idCountry = this.countryId, name = ""))

    companion object {
        fun fromEntity(state: StateUSA) = CreateStateDTO(name = state.name, countryId = state.countryId.idCountry)
    }
}
