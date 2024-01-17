package com.luciano.paisesecidades.repositories

import com.luciano.paisesecidades.model.Country
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CountryRepository:JpaRepository<Country, Long> {
    @Query("SELECT DISTINCT c FROM Country c LEFT JOIN FETCH c.states")
    fun findAllWithStates(): List<Country>
}