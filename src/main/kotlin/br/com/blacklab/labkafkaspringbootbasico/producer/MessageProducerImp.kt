package br.com.blacklab.labkafkaspringbootbasico.producer

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.util.concurrent.ListenableFutureCallback

@Component
class MessageProducerImp(
    private val messageTemplate: KafkaTemplate<Long, String>,
) {
    val topicName = "message-topic"
    fun send(msg: String) {
        val msgKey = 12345678L

        val future: ListenableFuture<SendResult<Long, String>> = messageTemplate.send(topicName, msg)
        future.addCallback(object: ListenableFutureCallback<SendResult<Long, String>> {
            override fun onSuccess(result: SendResult<Long, String>?) {
                println("Mensagem enviada. Key $msgKey")
            }
            override fun onFailure(ex: Throwable) {
                println("Erro ao enviar a mensagem. Key $msgKey")
            }
        })
    }
}