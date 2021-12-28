package com.example.todokotlin.model.http

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.validation.FieldError
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.Validation

class TodoDtoTest{
    val validator = Validation.buildDefaultValidatorFactory().validator

    @Test
    fun todoDtoFailTest(){
        val todoDto = TodoDto().apply {
            this.title = ""
            this.description = ""
            this.schedule = ""
            this.createdAt = "2222-02-02 22:22:232"
        }

        val result = validator.validate(todoDto)
        result.forEach {
            println(it.propertyPath.last().name)
            println(it.message)
            println(it.invalidValue)
        }

        assertEquals(false, result.isEmpty())
    }

    @Test
    fun todoDtoTest(){
        val todoDto = TodoDto().apply {
            this.title = "테스트"
            this.description = ""
            this.schedule = "2222-02-02 22:22:22"
            this.createdAt = "2222-02-02 22:22:22"
        }

        val result = validator.validate(todoDto)
        result.forEach {
            println(it.propertyPath.last().name)
            println(it.message)
            println(it.invalidValue)
        }

        assertEquals(true, result.isEmpty())
    }
}