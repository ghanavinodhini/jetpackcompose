package com.example.jetpackcompose.feature_todotasks.presentation.todolist

import com.example.jetpackcompose.feature_todotasks.domain.model.Todo
import com.example.jetpackcompose.feature_todotasks.domain.util.OrderType
import com.example.jetpackcompose.feature_todotasks.domain.util.TodoOrder

data class TodoState(
    val tasks: List<Todo> = emptyList(),
    val todoOrder: TodoOrder = TodoOrder.Date(OrderType.Descending),
    val isTaskDone: Boolean = false
)
