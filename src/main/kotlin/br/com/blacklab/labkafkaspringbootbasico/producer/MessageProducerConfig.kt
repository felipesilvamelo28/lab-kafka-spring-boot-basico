package br.com.blacklab.labkafkaspringbootbasico.producer

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class MessageProducerConfig {
    @Bean
    fun stockDTOTemplate(factory: ProducerFactory<Long, String>): KafkaTemplate<Long, String> {
        return KafkaTemplate(factory)
    }
}