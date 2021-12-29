package com.example.todokotlin.model.http

import annotation.StringFormatDateTime
import com.example.todokotlin.database.Todo
import java.time.format.DateTimeFormatter
import javax.validation.constraints.NotBlank

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

fun TodoDto.convertTodoDto(todo: Todo): TodoDto {
    return TodoDto().apply {
        this.index = todo.index
        this.title = todo.title
        this.description = todo.description
        this.schedule = todo.schedule?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        this.createdAt = todo.createdAt?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        this.updatedAt = todo.updatedAt?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    }
}