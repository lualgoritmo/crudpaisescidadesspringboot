package com.luciano.paisesecidades.service.impl

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaMessageListener {
    @KafkaListener(topics = ["primeiro-topico"], groupId = "group-1")
    fun receiveMessage(message: String) {
        println("Mensagem recebida: $message")
    }

}
