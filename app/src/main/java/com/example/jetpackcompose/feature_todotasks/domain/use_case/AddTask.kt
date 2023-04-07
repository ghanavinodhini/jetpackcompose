package com.example.jetpackcompose.feature_todotasks.domain.use_case

import com.example.jetpackcompose.feature_todotasks.domain.model.InvalidTodoException
import com.example.jetpackcompose.feature_todotasks.domain.model.Todo
import com.example.jetpackcompose.feature_todotasks.domain.repository.TodoRepository

class AddTask(private val repository: TodoRepository)
{
    @Throws(InvalidTodoException::class)
    suspend operator fun invoke(todo: Todo){
        if(todo.todo.isBlank()){
            throw InvalidTodoException("The title of todo can't be empty")
        }
        repository.insertTask(todo)
    }
}