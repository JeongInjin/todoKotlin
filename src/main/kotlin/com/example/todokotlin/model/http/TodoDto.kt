package com.example.todokotlin.model.http

import annotation.StringFormatDateTime
import org.springframework.lang.Nullable
import java.time.LocalDateTime
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Null

data class TodoDto(

    var index: Int? = null,

    @field:NotBlank
    var title: String? = null,

    var description: String? = null,

    @field:NotBlank
    @field:StringFormatDateTime
    var schedule: String? = null,

    @field: StringFormatDateTime
    var createdAt: String? = null,

    @field: StringFormatDateTime
    var updatedAt: String? = null,
)