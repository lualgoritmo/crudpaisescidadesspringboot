package com.luciano.paisesecidades.repositories

import com.luciano.paisesecidades.model.StateUSA
import org.springframework.data.jpa.repository.JpaRepository

interface StateRepository : JpaRepository<StateUSA, Long>
