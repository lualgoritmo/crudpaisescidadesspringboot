package com.luciano.paisesecidades.service.impl

import com.luciano.paisesecidades.model.StateUSA
import com.luciano.paisesecidades.repositories.StateRepository
import com.luciano.cadastropessoa.cadastrarpessoa.service.StateService
import com.luciano.paisesecidades.extension.StateNotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class StateServiceImpl(private val stateRepository: StateRepository) : StateService {
    override fun createState(state: StateUSA): StateUSA = stateRepository.save(state)
    override fun getAllStates(): List<StateUSA> = stateRepository.findAll()
    @Transactional
    override fun getWithIdState(idState: Long): StateUSA {
        return stateRepository.findById(idState).orElseThrow {
            throw StateNotFoundException(idState)
        }
    }
    override fun updateWithIdState(idState: Long, updateState: StateUSA): StateUSA {
        val existingState = stateRepository.findById(idState).orElseThrow {
            StateNotFoundException(idState)
        }
        val newState = existingState.copy(name = updateState.name)
        return stateRepository.save(newState)
    }
    @Transactional
    override fun deleteWithIdState(idState: Long) {
        try {
            stateRepository.deleteById(idState)
        } catch (ex: StateNotFoundException) {
            throw ex
        }
    }

}
