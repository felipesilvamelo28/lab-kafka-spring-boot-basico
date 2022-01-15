package br.com.blacklab.labkafkaspringbootbasico

import br.com.blacklab.labkafkaspringbootbasico.producer.MessageProducerImp
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LabKafkaSpringBootBasicoApplication(
	val producer: MessageProducerImp
): ApplicationRunner {
	override fun run(args: ApplicationArguments?) {
		val msg = "Mensagem Teste Black Lab"
		producer.send(msg)
	}
}

fun main(args: Array<String>) {
	runApplication<LabKafkaSpringBootBasicoApplication>(*args)
}
