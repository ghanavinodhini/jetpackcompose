package com.example.jetpackcompose.feature_todotasks.domain.use_case

import com.example.jetpackcompose.feature_todotasks.domain.model.Todo
import com.example.jetpackcompose.feature_todotasks.domain.repository.TodoRepository
import com.example.jetpackcompose.feature_todotasks.domain.util.OrderType
import com.example.jetpackcompose.feature_todotasks.domain.util.TodoOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTasks(
    private val repository: TodoRepository
) {

    operator fun invoke(
        todoOrder: TodoOrder = TodoOrder.Date(OrderType.Descending)
    ): Flow<List<Todo>> {
        return repository.getTasks().map { tasks ->
            when(todoOrder.orderType){
                is OrderType.Ascending -> {
                    when(todoOrder){
                        is TodoOrder.Title -> tasks.sortedBy { it.todo.lowercase() }
                        is TodoOrder.Date -> tasks.sortedBy { it.time }
                    }
                }
                is OrderType.Descending -> {
                    when(todoOrder){
                        is TodoOrder.Title -> tasks.sortedByDescending { it.todo.lowercase() }
                        is TodoOrder.Date -> tasks.sortedByDescending { it.time }
                    }
                }
            }
        }
    }
}