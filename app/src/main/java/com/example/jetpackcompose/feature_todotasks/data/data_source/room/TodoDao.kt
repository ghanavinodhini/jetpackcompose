package com.example.jetpackcompose.feature_todotasks.data.data_source.room

import androidx.room.*
import com.example.jetpackcompose.feature_todotasks.domain.model.Todo
import kotlinx.coroutines.flow.Flow


@Dao
interface TodoDao {

    @Query("SELECT * FROM todo")
    fun selectAll() : Flow<List<Todo>>

    @Query("SELECT * FROM todo WHERE id = :id")
    suspend fun getTaskById(id:Int): Todo?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo : Todo)

   /* @Query("DELETE FROM todo WHERE id = :id")
    suspend fun delete(id : Int)*/

    @Delete
    suspend fun deleteTask(todo: Todo)

    @Query("DELETE FROM todo")
    suspend fun deleteAll()
}