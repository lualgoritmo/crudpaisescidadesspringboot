package com.luciano.paisesecidades.extension

data class ErrorResponse(
    var httpCode: Int,
    var message: String,
    var internalCode: String,
    var erros: List<FieldResponseErros>?
)

data class FieldResponseErros(
    var message: String,
    var field: String
)
