package br.com.blacklab.labkafkaspringbootbasico.consumer

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class MessageConsumerImp {
    @KafkaListener(topics = ["message-topic"])
    fun consumer(msg: String) {
        println("Mensagem recebida: $msg")
    }
}