package com.luciano.paisesecidades.model

import jakarta.persistence.*

@Entity
@Table(name = "tb_states")
data class StateUSA(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idState: Long,
    val name: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "country_id")
    val countryId: Country
)
