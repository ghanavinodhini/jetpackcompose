package com.example.jetpackcompose.feature_todotasks.data.repository

import com.example.jetpackcompose.feature_todotasks.data.data_source.room.TodoDao
import com.example.jetpackcompose.feature_todotasks.domain.model.Todo
import com.example.jetpackcompose.feature_todotasks.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(private val dao: TodoDao) : TodoRepository {

    override fun getTasks(): Flow<List<Todo>> {
        return dao.selectAll()
    }

    override suspend fun getTaskById(id: Int): Todo? {
        return dao.getTaskById(id)
    }

    override suspend fun insertTask(todo: Todo) {
        return dao.insert(todo)
    }

    override suspend fun deleteTask(todo: Todo) {
        return dao.deleteTask(todo)
    }
}