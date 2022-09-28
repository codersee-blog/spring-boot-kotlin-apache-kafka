package com.codersee.kafkaexample.producer

import com.codersee.kafkaexample.config.EXAMPLE_TOPIC_NAME_THREE
import com.codersee.kafkaexample.config.EXAMPLE_TOPIC_NAME_TWO
import com.codersee.kafkaexample.dto.ExampleDto
import com.codersee.kafkaexample.dto.UserDto
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ExampleJsonProducer(
    private val exampleDtoKafkaTemplate: KafkaTemplate<String, ExampleDto>,
    private val userDtoKafkaTemplate: KafkaTemplate<String, UserDto>
) {

    fun sendExampleDtoMessage(dto: ExampleDto) {
        exampleDtoKafkaTemplate.send(EXAMPLE_TOPIC_NAME_TWO, dto)
    }

    fun sendUserDtoMessage(dto: UserDto) {
        userDtoKafkaTemplate.send(EXAMPLE_TOPIC_NAME_THREE, dto)
    }
}