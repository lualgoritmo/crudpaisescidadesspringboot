package com.luciano.paisesecidades.controller

import com.luciano.paisesecidades.controller.dto.ResponseCountryWithStatesDTO
import com.luciano.paisesecidades.controller.dto.RequireCountryDTO
import com.luciano.paisesecidades.extension.CountryNotFoundException
import com.luciano.paisesecidades.model.Country
import com.luciano.paisesecidades.service.CountryService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/countrys")
class CountryController(private val countryServiceImpl: CountryService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCountry(@RequestBody @Valid createCountryDTO: RequireCountryDTO): RequireCountryDTO {
        val country: Country = countryServiceImpl.createCountrie(createCountryDTO.toEntity())
        try {
            return RequireCountryDTO.fromEntity(country)
        } catch (ex: MethodArgumentNotValidException) {
            throw ex
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllCountrys(): List<RequireCountryDTO> {
        val countryList: List<Country> = countryServiceImpl.getAllCountries()
        if (countryList.isEmpty()) {
            println(" Lista de Countries vazia")
        }
        return countryList.map { RequireCountryDTO.fromEntity(it) }.toList()
    }

    @GetMapping("/countriestate")
    @ResponseStatus(HttpStatus.OK)
    fun getAllCountriesWithStates(): List<ResponseCountryWithStatesDTO> = countryServiceImpl.getAllCountriesWithStates()

    @GetMapping("/{idCountry}")
    @ResponseStatus(HttpStatus.OK)
    fun getByIdCountry(@PathVariable idCountry: Long): RequireCountryDTO {
        try {
            val country: Country = countryServiceImpl.getWithIdCountry(idCountry)
            return RequireCountryDTO.fromEntity(country)
        } catch (ex: CountryNotFoundException) {
            throw ex
        }
    }

    @PutMapping("/{idCountry}")
    @ResponseStatus(HttpStatus.OK)
    fun updateWithIdCountry(
        @PathVariable idCountry: Long,
        @RequestBody @Valid updateCountryDTO: RequireCountryDTO
    ): RequireCountryDTO {
        val country: Country = countryServiceImpl.updateWithIdCountry(idCountry, updateCountryDTO.toEntity())
        return RequireCountryDTO.fromEntity(country)
    }

    @DeleteMapping("/{idCountry}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteWithIdContry(@PathVariable idCountry: Long) {
        try {
            return countryServiceImpl.deleteWithIdContry(idCountry)
        } catch (ex: CountryNotFoundException) {
            throw ex
        }
    }

//    @GetMapping("/countryAllstates")
//    @ResponseStatus(HttpStatus.OK)
//    fun countrywithstatesDTO(): List<CountryWithStatesDTO> {
//        val countries = countryService.getAllCountries()
//        return countries.map { country ->
//            CountryWithStatesDTO(
//                name = country.name, states = country.states.map { state ->
//                StateDTO(name = state.name)
//
//            }
//            )
//        }
//    }
}
