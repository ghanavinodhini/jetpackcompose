package com.example.jetpackcompose.feature_todotasks.domain.repository

import com.example.jetpackcompose.feature_todotasks.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun getTasks(): Flow<List<Todo>>

    suspend fun getTaskById(id: Int): Todo?

    suspend fun insertTask(todo: Todo)

    suspend fun deleteTask(todo: Todo)

}