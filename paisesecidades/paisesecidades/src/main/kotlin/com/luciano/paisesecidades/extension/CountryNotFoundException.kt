
package com.luciano.paisesecidades.extension

class CountryNotFoundException(idCountry:Long): RuntimeException("Não existe o id do Country: $idCountry")