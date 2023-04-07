package com.example.jetpackcompose.feature_todotasks.domain.use_case

import com.example.jetpackcompose.feature_todotasks.domain.model.Todo
import com.example.jetpackcompose.feature_todotasks.domain.repository.TodoRepository

class DeleteTask(private val repository: TodoRepository) {

    suspend operator fun invoke(todo: Todo){
        repository.deleteTask(todo)
    }
}