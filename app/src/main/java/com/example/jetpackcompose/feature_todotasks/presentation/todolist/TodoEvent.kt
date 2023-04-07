package com.example.jetpackcompose.feature_todotasks.presentation.todolist

import com.example.jetpackcompose.feature_todotasks.domain.model.Todo
import com.example.jetpackcompose.feature_todotasks.domain.util.TodoOrder

sealed class TodoEvent{
    data class Order(val todoOrder: TodoOrder) : TodoEvent()
    data class DeleteTask(val todo: Todo) : TodoEvent()
    //data class DoneTask(val todo: Todo) : TodoEvent()
    object RestoreTodo: TodoEvent()
    object ToggleDoneTask: TodoEvent()
}
