package com.luciano.paisesecidades.controller.dto

data class CountryWithStatesDTO(
    val name: String,
    val states: List<StateDTO>
)
