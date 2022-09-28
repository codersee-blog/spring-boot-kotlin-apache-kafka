package com.codersee.kafkaexample.controller

import com.codersee.kafkaexample.dto.ExampleDto
import com.codersee.kafkaexample.dto.UserDto
import com.codersee.kafkaexample.producer.ExampleJsonProducer
import com.codersee.kafkaexample.producer.ExampleStringProducer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class ExampleController(
    private val exampleStringProducer: ExampleStringProducer,
    private val exampleJsonProducer: ExampleJsonProducer
) {

    @PostMapping("/test")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun sendTestMessage(
        @RequestBody requestBody: RequestBodyDto
    ) {
        exampleStringProducer.sendStringMessage(
            message = requestBody.message
        )
        exampleJsonProducer.sendExampleDtoMessage(
            dto = ExampleDto(requestBody.message)
        )
        exampleJsonProducer.sendUserDtoMessage(
            dto = UserDto(
                id = Random.nextLong(0, 100),
                name = requestBody.message
            )
        )
    }

    data class RequestBodyDto(val message: String)
}
