package com.luciano.paisesecidades.extension
class StateNotFoundException(idState: Long): RuntimeException("Esse id não existe: $idState")