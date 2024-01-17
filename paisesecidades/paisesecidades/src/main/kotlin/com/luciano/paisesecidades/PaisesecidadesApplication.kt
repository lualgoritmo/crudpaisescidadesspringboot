package com.luciano.paisesecidades

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PaisesecidadesApplication

fun main(args: Array<String>) {
	runApplication<PaisesecidadesApplication>(*args)
	println("Hello, Word!")
}
