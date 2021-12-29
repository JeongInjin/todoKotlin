package com.example.todokotlin.model.http

import annotation.StringFormatDateTime
import com.example.todokotlin.database.Todo
import io.swagger.annotations.ApiModelProperty
import java.time.format.DateTimeFormatter
import javax.validation.constraints.NotBlank

data class TodoDto(

    @field:ApiModelProperty(
        value = "DB INDEX",
        example = "1",
        required = false
    )
    var index: Int? = null,

    @field:ApiModelProperty(
        value = "일정명",
        example = "일정관리",
        required = true
    )
    @field:NotBlank
    var title: String? = null,

    @field:ApiModelProperty(
        value = "일정설명",
        example = "10시 코딩테스트",
        required = false
    )
    var description: String? = null,

    @field:ApiModelProperty(
        value = "시간",
        example = "2022-02-02 22:22:22",
        required = true
    )
    @field:NotBlank
    @field:StringFormatDateTime
    var schedule: String? = null,

    @field:ApiModelProperty(
        value = "생성일자",
        example = "2022-02-02 22:22:22",
        required = false
    )
    @field: StringFormatDateTime
    var createdAt: String? = null,

    @field:ApiModelProperty(
        value = "수정일자",
        required = false
    )
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