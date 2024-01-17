package com.luciano.cadastropessoa.cadastrarpessoa.service

import com.luciano.paisesecidades.model.StateUSA

interface StateService {
    fun createState(state: StateUSA): StateUSA
    fun getAllStates(): List<StateUSA>
    fun getWithIdState(idState: Long): StateUSA
    fun updateWithIdState(idState: Long, updateState: StateUSA): StateUSA
    fun deleteWithIdState(idState: Long)
}