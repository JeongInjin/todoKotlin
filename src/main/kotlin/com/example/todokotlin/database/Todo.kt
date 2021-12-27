package com.example.todokotlin.database

import jdk.jfr.Description
import java.time.LocalDateTime

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
) {
}