package com.example.todokotlin.repository

import com.example.todokotlin.database.Todo
import com.example.todokotlin.database.TodoDataBase
import org.springframework.stereotype.Service
import java.lang.Exception
import java.time.LocalDateTime

@Service
class TodoRepositoryImpl(val todoDataBase: TodoDataBase) : TodoRepository {

//    override fun save(todo: Todo): Todo? {
//    println("todo : ${todo}")
//        return todo.apply {
//            this.index = ++todoDataBase.index
//            this.createdAt = LocalDateTime.now()
//            this.updatedAt = LocalDateTime.now()
//        }.run {
//            todoDataBase.todoList.add(todo)
//            this
//        }
//    }

    override fun save(todo: Todo): Todo?{

        return todo.index?.let {
            //update
            findOne(it)?.apply {
                this.title = todo.title
                this.description = todo.description
                this.schedule = todo.schedule
                this.updatedAt = LocalDateTime.now()
            }
        }?: kotlin.run {
            //insert
            todo.apply {
                this.index = ++todoDataBase.index
                this.createdAt = LocalDateTime.now()
                this.updatedAt = LocalDateTime.now()
            }.run {
                todoDataBase.todoList.add(todo)
                this
            }
        }
    }


    override fun saveAll(todoList: MutableList<Todo>): Boolean {
        return try {
            todoList.forEach {
                save(it)
            }
            true
        }catch (e: Exception){
            false
        }
    }

    override fun delete(index: Int): Boolean {
        return findOne(index)?.let {
            todoDataBase.todoList.remove(it)
            true
        }?: kotlin.run {
            false
        }
    }

    override fun findOne(index: Int?): Todo? {
        println("findOne : ${index}")
        return todoDataBase.todoList.first { it.index == index }
    }

    override fun findAll(): MutableList<Todo> {
        return todoDataBase.todoList
    }
}