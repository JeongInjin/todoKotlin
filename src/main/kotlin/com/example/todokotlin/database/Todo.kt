package com.example.todokotlin.database

import com.example.todokotlin.model.http.TodoDto
import jdk.jfr.Description
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Todo(
    @Description("일정 index")
    var index: Int? = null,
    @Description("일정 title")
    var title: String? = null,
    @Description("일정 설명")
    var description: String? = null,
    @Description("일정시간")
    var schedule: LocalDateTime? = null,
    @Description("생성시간")
    var createdAt: LocalDateTime? = null,
    @Description("업데이트시간")
    var updatedAt: LocalDateTime? = null,
)

fun Todo.convertTodo(todoDto: TodoDto): Todo{
    return Todo().apply {
        this.index = todoDto.index
        this.title = todoDto.title
        this.description = todoDto.description
        this.schedule = LocalDateTime.parse(todoDto.schedule, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

        todoDto.createdAt?.let {
            this.createdAt = LocalDateTime.parse(todoDto.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        }?: kotlin.run {
            this.createdAt = LocalDateTime.now()
        }

        todoDto.updatedAt?.let {
            this.updatedAt = LocalDateTime.parse(todoDto.updatedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        }?: kotlin.run {
            this.updatedAt = LocalDateTime.now()
        }

    }
}