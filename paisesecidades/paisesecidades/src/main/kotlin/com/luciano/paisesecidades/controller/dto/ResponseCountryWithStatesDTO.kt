package com.luciano.paisesecidades.controller.dto

data class ResponseCountryWithStatesDTO(
    val name: String,
    val states: List<StateDTO>
)
