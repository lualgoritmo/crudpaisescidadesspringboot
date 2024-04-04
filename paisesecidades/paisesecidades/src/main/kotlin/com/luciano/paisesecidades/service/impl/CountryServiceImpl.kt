package com.luciano.paisesecidades.service.impl

import com.luciano.paisesecidades.controller.dto.ResponseCountryWithStatesDTO
import com.luciano.paisesecidades.controller.dto.StateDTO
import com.luciano.paisesecidades.extension.CountryNotFoundException
import com.luciano.paisesecidades.model.Country
import com.luciano.paisesecidades.repositories.CountryRepository
import com.luciano.paisesecidades.service.CountryService
import jakarta.transaction.Transactional
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class CountryServiceImpl(
    private val countryRepository: CountryRepository
) : CountryService {
    override fun createCountrie(country: Country): Country = countryRepository.save(country)
    override fun getAllCountries(): List<Country> = countryRepository.findAll()

    @Transactional
    override fun getWithIdCountry(idCountry: Long): Country = countryRepository.findById(idCountry).orElseThrow {
        CountryNotFoundException(idCountry)
    }

    @Transactional
    override fun getAllCountriesWithStates(): List<ResponseCountryWithStatesDTO> {
        val countries = countryRepository.findAllWithStates()
        return countries.map {ResponseCountryWithStatesDTO(
                name = it.name,
                states = it.states.map { state ->
                    StateDTO(
                        name = state.name
                    )
                }
            )
        }

    }
    @Transactional
    override fun updateWithIdCountry(idCountry: Long, updateCountry: Country): Country {
        val existingCountry = countryRepository.findById(idCountry).orElseThrow {
            CountryNotFoundException(idCountry)
        }
        val newCountry: Country = existingCountry.copy(
            name = updateCountry.name,
            states = updateCountry.states
        )
        return countryRepository.save(newCountry)
    }
    @Transactional
    override fun deleteWithIdContry(idCountry: Long) {
        try {
            countryRepository.deleteById(idCountry)
        } catch (ex: EmptyResultDataAccessException) {
            throw CountryNotFoundException(idCountry)
        }
    }
}
